package com.prudential.rental.service.impl;

import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.entity.RentCar;
import com.prudential.rental.entity.RentOrder;
import com.prudential.rental.enums.OrderStateEnum;
import com.prudential.rental.mapper.RentCarMapper;
import com.prudential.rental.service.IRentCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Car information table 服务实现类
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Service
public class RentCarServiceImpl extends ServiceImpl<RentCarMapper, RentCar> implements IRentCarService {


    @Autowired
    private RentCarMapper rentCarMapper;

    /**
     * get car list by params
     * @param startTime rent start time
     * @param endTime rent end time
     * @return car list
     */
    @Override
    public List<RentCar> getCarListByParams(Date startTime, Date endTime) {
        Map<String, Object> rentingCondition = new HashMap<>();
        rentingCondition.put("state", OrderStateEnum.RENTING.getValue());
        rentingCondition.put("startTime", startTime);
        rentingCondition.put("endTime", endTime);
        List<Integer> rentingCarIdList = rentCarMapper.getRentingCarIdList(rentingCondition);
        Map<String, Object> availableCondition = new HashMap<>();
        availableCondition.put("rentingCarIdList", rentingCarIdList);
        return rentCarMapper.getAvailableCarList(availableCondition);
    }


}
