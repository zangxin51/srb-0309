package com.atguigu.srb.common.exception;

import com.atguigu.srb.base.result.R;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName UnifiedExceptionHandler.java
 * @Description TODO
 * @createTime 2022年07月15日 16:50:00
 */
@Component
@RestControllerAdvice
public class UnifiedExceptionHandler {
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        System.out.println("通用异常通知方法");
        System.out.println(e.getMessage());
        return R.error().data("error", "对不起,服务器开小差了");
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public R sqlExceptionHandler(BadSqlGrammarException e) {
        System.out.println("sql语法错误");
        System.out.println(e.getMessage());
        return R.error().data("error", "sql语法错误");
    }

    @ExceptionHandler(BusinessException.class)
    public R businessExceptionHandler(BusinessException e) {
        System.out.println("业务通知方法");
        System.out.println(e.getMessage());
        return R.error().data("error", e.getMessage());
    }
}
