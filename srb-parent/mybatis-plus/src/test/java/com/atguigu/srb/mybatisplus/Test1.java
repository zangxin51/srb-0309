package com.atguigu.srb.mybatisplus;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description TODO
 * @createTime 2022年07月08日 17:55:00
 */
@SpringBootTest
public class Test1 {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void crudTest(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.err::println);
    }


    @Test
    public void test1(){
        System.out.println(1);
    }


}
