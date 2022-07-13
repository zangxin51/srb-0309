package com.atguigu.srb.core;

import com.atguigu.srb.core.pojo.entity.BorrowInfo;
import com.atguigu.srb.core.service.BorrowInfoService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName BorrowerInfoTest.java
 * @Description TODO
 * @createTime 2022年07月13日 20:15:00
 */
@SpringBootTest
public class BorrowerInfoTest {

    @Autowired
    private BorrowInfoService borrowInfoService;
    @Test
    public void test01(){
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setUserId(100L);
        boolean save = borrowInfoService.save(borrowInfo);
        System.out.println("是否保存成功:" + save);
    }

    @Test
    public void test02(){
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setUserId(200L);
        UpdateWrapper<BorrowInfo> borrowInfoUpdateWrapper = new UpdateWrapper<>();
        borrowInfoUpdateWrapper.eq("user_id", 200);
        boolean update = borrowInfoService.update(borrowInfo, borrowInfoUpdateWrapper);
        System.out.println("是否更新成功:" + update);

    }
}
