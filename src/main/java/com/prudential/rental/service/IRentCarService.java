package com.prudential.rental.service;

import com.prudential.rental.dto.RentCarParams;
import com.prudential.rental.entity.RentCar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Car information table 服务类
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
public interface IRentCarService extends IService<RentCar> {

    List<RentCar> getCarListByParams(Date startTime, Date endTime);

}
