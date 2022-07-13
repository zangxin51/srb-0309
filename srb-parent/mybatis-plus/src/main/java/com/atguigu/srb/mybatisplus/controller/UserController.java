package com.atguigu.srb.mybatisplus.controller;

import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.atguigu.srb.mybatisplus.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2022年07月12日 11:10:00
 */
@RestController()
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        return userService.list();
    }
}
