package com.prudential.rental.service;

import com.prudential.rental.dto.OrderListParams;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.entity.RentOrder;
import com.prudential.rental.enums.OrderStateEnum;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * users information table 服务类
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
public interface IRentOrderService extends IService<RentOrder> {

    void updateState(Integer id, Integer state);

    List<RentOrder> getOrderListByParams(Integer uid, Integer state, Date startTime, Date endTime);

    void rent(RentCarParams rentCarParams);

}
