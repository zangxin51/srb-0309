package com.atguigu.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName ExcelStudentDTO.java
 * @Description TODO
 * @createTime 2022年07月18日 14:31:00
 */
@Data
public class ExcelStudentDTO {
    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("薪资")
    private Double salary;
}
