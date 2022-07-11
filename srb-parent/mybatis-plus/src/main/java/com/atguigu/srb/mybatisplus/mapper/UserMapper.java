package com.atguigu.srb.mybatisplus.mapper;

import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2022年07月08日 18:06:00
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     *自定义的分页方法,也定义对应mapper的sql语句
     * @return ipage
     * @param IPage
     */
    IPage<User> selectByMyPage(@Param("iPage") IPage<User> iPage);
    /**
     * 根据用户名字查找用户
     * @param name
     * @return
     */
    List<User> getUserByName(@Param("name") String name);
}
