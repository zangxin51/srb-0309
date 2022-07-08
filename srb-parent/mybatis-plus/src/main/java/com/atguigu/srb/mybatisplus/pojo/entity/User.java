package com.atguigu.srb.mybatisplus.pojo.entity;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年07月08日 18:02:00
 */

import lombok.Data;

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
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
