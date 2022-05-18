package com.prudential.rental.service.impl;

import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.entity.RentCar;
import com.prudential.rental.entity.RentOrder;
import com.prudential.rental.enums.OrderStateEnum;
import com.prudential.rental.exception.BusinessException;
import com.prudential.rental.mapper.RentCarMapper;
import com.prudential.rental.mapper.RentOrderMapper;
import com.prudential.rental.service.IRentOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prudential.rental.web.ErrorCodeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * users information table 服务实现类
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Service
public class RentOrderServiceImpl extends ServiceImpl<RentOrderMapper, RentOrder> implements IRentOrderService {

    private static final Object lockRent = new Object();


    @Autowired
    private RentOrderMapper rentOrderMapper;
    @Autowired
    private RentCarMapper rentCarMapper;

    /**
     * update order state
     * @param id order id
     * @param state order state
     */
    @Override
    public void updateState(Integer id, Integer state) {

        RentOrder order = this.getById(id);
        if(order == null){
            throw new BusinessException(ErrorCodeConfig.ERR_ORDER_NOT_EXIST);
        }
        if(!order.getState().equals(OrderStateEnum.RENTING.getValue())){
            throw new BusinessException(ErrorCodeConfig.ERR_ORDER_STATE);
        }
        order.setState(state);
        order.setUpdateTime(new Date());
        this.updateById(order);
    }


    /**
     * get order list by params
     * @param uid
     * @param state
     * @param startTime
     * @param endTime
     * @return order list
     */
    @Override
    public List<RentOrder> getOrderListByParams(Integer uid, Integer state, Date startTime, Date endTime) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("uid", uid);
        condition.put("state", state);
        condition.put("startTime", startTime);
        condition.put("endTime", endTime);
        return rentOrderMapper.listSelective(condition);
    }


    /**
     * rent a car
     * @param rentCarParams
     */
    @Override
    public void rent(RentCarParams rentCarParams) {
        Integer carId = rentCarParams.getCarId();
        Map<String, Object> rentingCondition = new HashMap<>();
        rentingCondition.put("state", OrderStateEnum.RENTING.getValue());
        rentingCondition.put("startTime", rentCarParams.getStartTime());
        rentingCondition.put("endTime", rentCarParams.getEndTime());

        //if the application is deployed in more than one machines, we should use distributed redis lock.
        //Because we deploy in just one single machine, "synchronized" can do that
        synchronized (lockRent) {
            List<Integer> rentingCarIdList = rentCarMapper.getRentingCarIdList(rentingCondition);
            if(rentingCarIdList.contains(carId)){
                throw new BusinessException(ErrorCodeConfig.ERR_CAR_NO_STOCK);
            }
            RentCar carInfo = rentCarMapper.selectById(carId);
            if (carInfo == null) {
                throw new BusinessException(ErrorCodeConfig.ERR_CAR_NOT_EXIST);
            }

            RentOrder order = new RentOrder();
            order.setUid(rentCarParams.getUid());
            order.setCarId(rentCarParams.getCarId());
            order.setStartTime(rentCarParams.getStartTime());
            order.setEndTime(rentCarParams.getEndTime());
            order.setState(OrderStateEnum.RENTING.getValue());
            order.setCreateTime(new Date());
            this.save(order);
        }

    }


}
