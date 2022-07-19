package com.atguigu.srb.core;

import com.atguigu.srb.base.result.ResponseEnum;
import com.atguigu.srb.common.exception.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName AssertTest.java
 * @Description TODO
 * @createTime 2022年07月15日 18:30:00
 */
public class AssertTest {

    @Test
    public void test03(){
        //测试Assert类
        Assert.isTrue(1 == 1, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Object o = new Object();
        Object o2 = o;
        Assert.isEquals(o, o2,ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.isNull(null, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.notNull(1, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.notEquals(1, 2, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.isEquals(1,1,ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.notEmpty("p", ResponseEnum.ALIYUN_SMS_ERROR);

    }

    @Test
    public void test02(){
        Object o = new Object();
        o  = null;
        Assert.notNull(o, ResponseEnum.ALIYUN_SMS_ERROR);
    }
    /**
     * 未使用断言时
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        Object o = new Object();
        o  = null;
        if (o == null) {
            throw new Exception("不能为空");
        }

    }

}
