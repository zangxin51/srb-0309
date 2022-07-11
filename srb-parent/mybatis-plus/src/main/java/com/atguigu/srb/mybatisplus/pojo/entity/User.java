package com.atguigu.srb.mybatisplus.pojo.entity;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年07月08日 18:02:00
 */

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Field   Type         Null    Key     Default  Extra
 * ------  -----------  ------  ------  -------  --------
 * id      bigint       NO      PRI     (NULL)
 * name    varchar(30)  YES             (NULL)
 * age     int          YES             (NULL)
 * email   varchar(50)  YES             (NULL)
 *
 * @author 32929
 */
@Data
@TableName(value = "user") //通过注解可以对应实体和数据库表名称
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("email")
    private String email;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "is_deleted")
    @TableLogic(value = "0", delval = "1")
    private byte deleted;

}
