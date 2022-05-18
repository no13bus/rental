package com.prudential.rental.mapper;

import com.prudential.rental.entity.RentUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * users information table Mapper 接口
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Mapper
public interface RentUserMapper extends BaseMapper<RentUser> {

}
