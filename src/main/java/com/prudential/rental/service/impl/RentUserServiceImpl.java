package com.prudential.rental.service.impl;

import com.prudential.rental.entity.RentUser;
import com.prudential.rental.mapper.RentUserMapper;
import com.prudential.rental.service.IRentUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * users information table 服务实现类
 * </p>
 *
 * @author jarvis.jia
 * @since 2022-05-18
 */
@Service
public class RentUserServiceImpl extends ServiceImpl<RentUserMapper, RentUser> implements IRentUserService {

}
