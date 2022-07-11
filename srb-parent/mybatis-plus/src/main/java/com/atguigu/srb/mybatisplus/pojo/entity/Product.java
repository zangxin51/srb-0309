package com.atguigu.srb.mybatisplus.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName Product.java
 * @Description TODO
 * @createTime 2022年07月10日 22:40:00
 */
@TableName("product")
@Data
public class Product {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name")
    private String name;
    @TableField("price")
    private Integer price;
    @TableField("version")
    @Version
    private Integer version;
}
