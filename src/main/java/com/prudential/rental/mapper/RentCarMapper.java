package com.prudential.rental.mapper;

import com.prudential.rental.entity.RentCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Car information table Mapper 接口
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Mapper
public interface RentCarMapper extends BaseMapper<RentCar> {

    List<RentCar> getAvailableCarList(Map<String, Object> conditions);

    List<Integer> getRentingCarIdList(Map<String, Object> conditions);
}
