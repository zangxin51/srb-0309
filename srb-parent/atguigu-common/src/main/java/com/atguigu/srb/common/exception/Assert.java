package com.atguigu.srb.common.exception;

import com.atguigu.srb.base.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName Assert.java
 * @Description TODO
 * @createTime 2022年07月15日 18:33:00
 */
@Slf4j
public class Assert {

    /**
     * 断言对象不为空
     * 如果对象obj为空,则抛出异常
     * @param obj
     * @param responseEnum obj 为空则抛出异常
     */
    public static void notNull(Object obj, ResponseEnum responseEnum) {
        if (obj == null) {
            log.info("obj is null.......");
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言对象为空
     * @param obj
     * @param responseEnum 如果obj 不为空则抛出异常
     */
    public static void isNull(Object obj, ResponseEnum responseEnum) {
        if (obj != null) {
            log.info("obj is not null......");
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言表达式为真,如果不为真，则抛出异常
     * @param expression 断言表达式为真,如果不为真，则抛出异常
     * @param responseEnum
     */
    public static void isTrue(boolean expression, ResponseEnum responseEnum) {
        if (!expression) {
            log.info("fail...........................");
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言两个对象不相等
     *  如果相等，则抛出异常
     * @param obj1
     * @param obj2
     * @param responseEnum
     */
    public static void notEquals(Object obj1, Object obj2, ResponseEnum responseEnum) {
        if (obj1.equals(obj2)) {
            log.info("equals......................");
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言两个对象相等
     * 如果不相等，则抛出异常
     * @param obj1
     * @param obj2
     * @param responseEnum
     */
    public static void isEquals(Object obj1, Object obj2, ResponseEnum responseEnum) {
        if (!obj1.equals(obj2)) {
            log.info("Not equals......................");
            throw new BusinessException(responseEnum);
        }
    }

    /**
     * 断言参数不为空
     * 如果为空，则抛出异常
     * @param s
     * @param responseEnum
     */
    public static void notEmpty(String s, ResponseEnum responseEnum) {
        if (StringUtils.isEmpty(s)) {
            log.info("Is empty................");
            throw new BusinessException(responseEnum);
        }
    }

}
