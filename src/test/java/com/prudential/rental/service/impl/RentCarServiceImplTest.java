package com.prudential.rental.service.impl;

import cn.hutool.core.date.DateUtil;
import com.prudential.rental.entity.RentCar;
import com.prudential.rental.service.IRentCarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jarvis.jia
 * @date 2022/5/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class RentCarServiceImplTest {

    @Autowired
    private IRentCarService rentCarService;

    @Test
    void getCarListByParams() {
        Date startTime = DateUtil.parse("2022-05-18 10:00:00", "yyyy-MM-dd HH:mm:ss");
        Date endTime = DateUtil.parse("2022-05-20 10:00:00", "yyyy-MM-dd HH:mm:ss");
        List<RentCar>  carList = rentCarService.getCarListByParams(startTime, endTime);
        assertEquals(3, carList.size());
    }
}