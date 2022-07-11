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
 * @ClassName MapperTest.java
 * @Description TODO
 * @createTime 2022年07月09日 14:57:00
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserByNameTest(){
        List<User> userList = userMapper.getUserByName("小");
        userList.forEach(System.out::println);
    }

}
