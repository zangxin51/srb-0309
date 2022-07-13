package com.atguigu.srb.core;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName BootTest.java
 * @Description TODO
 * @createTime 2022年07月13日 17:02:00
 */

@SpringBootTest
public class BootTest {
    
    @Test
    public void test01(){
        System.out.println(1);
        try {
            Driver driver = new Driver();
            System.out.println(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Test
    public void test02(){
        Connection conn;
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:13306/srb_core?serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=true";
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
