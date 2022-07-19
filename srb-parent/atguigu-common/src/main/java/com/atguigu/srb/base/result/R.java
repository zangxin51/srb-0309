package com.atguigu.srb.base.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName R.java
 * @Description TODO
 * @createTime 2022年07月15日 11:33:00
 */

@Data
public class R {
    private Integer code;
    private String message;
    private Map<String, Object> data =new HashMap<>();

    /**
     * 私有化构造器
     */
    private R(){}

    /**
     * successful
     * @return
     */
    public static R ok() {
        R r = new R();
        //SUCCESS(0, "成功"),
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * failed
     */
    public static R error() {
        R r = new R();
        //    ERROR(-1, "服务器内部错误"),
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    /**
     * 返回指定的结果
     * @param responseEnum
     * @return
     */
    public static R setResult(ResponseEnum responseEnum) {
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    /**
     * 设置data
     * @param key
     * @param value
     * @return
     */
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 设置data
     * 将map赋值给当前对象
     * @param map
     * @return
     */
    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    /**
     * 设置特定的响应码
     * @param message
     * @return
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }


}
