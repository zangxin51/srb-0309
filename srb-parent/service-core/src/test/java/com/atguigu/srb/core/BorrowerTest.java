package com.atguigu.srb.core;

import com.atguigu.srb.core.mapper.BorrowerMapper;
import com.atguigu.srb.core.pojo.entity.Borrower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName BorrowerTest.java
 * @Description TODO
 * @createTime 2022年07月13日 19:38:00
 */
@SpringBootTest
public class BorrowerTest {

    @Autowired
    private BorrowerMapper borrowerMapper;

    @Test
    public void test01(){
        List<Borrower> borrowers = borrowerMapper.selectList(null);
        borrowers.forEach(System.err::println);
    }

}
