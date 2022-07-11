package com.atguigu.srb.mybatisplus;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName PageTest.java
 * @Description TODO
 * @createTime 2022年07月10日 21:37:00
 */
@SpringBootTest
public class PageTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 自定义的分页方法
     */
    @Test
    public void test02(){
        IPage<User> iPage = new Page<>();
        iPage.setSize(3);
        iPage.setCurrent(3);
        IPage<User> userPage = userMapper.selectByMyPage(iPage);
        List<User> records = userPage.getRecords();
        records.forEach(System.err::println);

    }


    @Test
    public void test01(){
        IPage<User> iPage = new Page<>();
        iPage.setSize(3);
        iPage.setCurrent(1);
        IPage<User> userIPage  = userMapper.selectPage(iPage, null);
        long total = userIPage.getTotal();
        long size = userIPage.getSize();
        long current = userIPage.getCurrent();
        List<User> records = userIPage.getRecords();
        System.out.println("满足条件的记录条数: "+total);
        System.out.println("每页的容量: " + size);
        System.out.println("当前的为第 " + current + " 页");
        System.out.println("下面是记录");
        records.forEach(System.err::println);


    }
}
