package com.prudential.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prudential.rental.entity.RentOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * users information table Mapper 接口
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Mapper
public interface RentOrderMapper extends BaseMapper<RentOrder> {

    List<RentOrder> listSelective(Map<String, Object> condition);

    RentOrder findSelective(Map<String, Object> condition);

}
