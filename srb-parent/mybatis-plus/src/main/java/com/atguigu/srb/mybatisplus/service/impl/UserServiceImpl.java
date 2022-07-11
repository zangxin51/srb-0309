package com.atguigu.srb.mybatisplus.service.impl;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.atguigu.srb.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2022年07月09日 11:05:00
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
