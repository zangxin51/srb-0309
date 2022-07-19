package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.atguigu.easyexcel.event.ExcelStudentDTOListener;
import com.atguigu.easyexcel.pojo.ExcelStudentDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName EasyExcelTest.java
 * @Description TODO
 * @createTime 2022年07月18日 14:28:00
 */

public class EasyExcelTest {

    @Test
    public void test02(){

        EasyExcel.read("x:/simpleWrite.xlsx",ExcelStudentDTO.class ,
                new ExcelStudentDTOListener())
                // 这里默认读取第一个sheet
                .sheet().doRead();
    }

    @Test
    public void test01(){
        System.out.println("hello");
        List<ExcelStudentDTO> excelStudentDTOList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ExcelStudentDTO excelStudentDTO = new ExcelStudentDTO();
            excelStudentDTO.setName("小"+i);
            excelStudentDTO.setBirthday(new Date());
            excelStudentDTO.setSalary(i*10d);
            excelStudentDTOList.add(excelStudentDTO);
        }

        EasyExcel.write("x:/simpleWrite.xlsx", ExcelStudentDTO.class)
                .sheet("模板").doWrite(excelStudentDTOList);
    }
}
