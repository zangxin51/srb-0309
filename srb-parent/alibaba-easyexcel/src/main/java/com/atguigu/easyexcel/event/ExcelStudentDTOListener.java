package com.atguigu.easyexcel.event;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.easyexcel.pojo.ExcelStudentDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName ExcelStudentDTOListener.java
 * @Description TODO
 * @createTime 2022年07月18日 14:43:00
 */
@Slf4j
public class ExcelStudentDTOListener extends AnalysisEventListener<ExcelStudentDTO> {


    @Override
    public void invoke(ExcelStudentDTO excelStudentDTO, AnalysisContext analysisContext) {
        log.info("每读取一行数据就调用一次: "+excelStudentDTO.getName());


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}
