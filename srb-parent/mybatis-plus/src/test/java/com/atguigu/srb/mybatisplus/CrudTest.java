package com.atguigu.srb.mybatisplus;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.atguigu.srb.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName CrudTest.java
 * @Description TODO
 * @createTime 2022年07月09日 11:08:00
 */
@SpringBootTest
public class CrudTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser(){
        User user = new User();
//        user.setId(); 有自增的主键
        user.setName("安培小三");
        user.setEmail("apss@gg.com");
        user.setAge(78);
        int insert = userMapper.insert(user);
//        System.out.println(1/0); //默认没有事务
        user.setName("安培小三111");
        int insert1 = userMapper.insert(user);
        System.out.println("受影响的行数: " + insert);
    }

    /**
     * @title deleteTest
     * @description 删除用户
     * @author cqs
     * @param
     * @updateTime 2022/7/9 11:40
     * @return
     * @throws
     */
    @Test
    public void deleteTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "安培小三");
        int i = userMapper.deleteByMap(map);
        System.out.println("受影响的行数: " + i);
    }

/**
 * @title updateTest
 * @description 更新测试
 * @author cqs
 * @param
 * @updateTime 2022/7/9 11:36
 * @return
 * @throws
 */
    @Test
    public void updateTest(){
        User user = new User();
        /**主键
         *
         */
        user.setId(1L);
        user.setAge(180);
        int b = userMapper.updateById(user);
        System.out.println("受影响的行数" + b);

    }
    /**
     * @title queryTest2
     * @description userMapper的批处理查询方法,其中源码用了默认方法
     * @author cqs
     * @param
     * @updateTime 2022/7/9 11:31
     * @return
     * @throws
     */
    @Test
    public void queryTest2(){
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        List<User> userList = userMapper.selectBatchIds(integers);
        userList.forEach(System.err::println);


    }

    /**
     * @title 查询
     * @description
     * @author cqs
     * @param
     * @updateTime 2022/7/9 11:20
     * @return
     * @throws
     */
    @Test
    public void queryTests(){
        List<User> list = userService.list();
        User byId = userService.getById(1);
        list.forEach(System.err::println);
        System.out.println(byId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "安培小三");
        List<User> name = userService.listByMap(map);
        System.err.println(name);
    }
}
