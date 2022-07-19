package com.atguigu.srb.common.exception;

import com.atguigu.srb.base.result.ResponseEnum;
import lombok.Data;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName BusinessException.java
 * @Description TODO
 * @createTime 2022年07月15日 18:14:00
 */
@Data
public class BusinessException extends RuntimeException{
    private Integer code;
    private String message;

    public BusinessException(ResponseEnum badSqlGrammarError) {
        this.code = badSqlGrammarError.getCode();
        this.message = badSqlGrammarError.getMessage();
    }
}
