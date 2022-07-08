package com.atguigu.srb.mybatisplus.mapper;

import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2022年07月08日 18:06:00
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
