package com.atguigu.srb.core.easyexcel.event;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName ExcelDictDTOListener.java
 * @Description TODO
 * @createTime 2022年07月18日 18:33:00
 */
@NoArgsConstructor
public class ExcelDictDTOListener extends AnalysisEventListener<ExcelDictDTO> {

    private DictMapper dictMapper;

    public ExcelDictDTOListener(DictMapper baseMapper) {
        this.dictMapper = baseMapper;
    }

    private List<ExcelDictDTO> excelDictDTOList = new ArrayList<>();
    @Override
    public void invoke(ExcelDictDTO excelDictDTO, AnalysisContext analysisContext) {
        System.out.println("读取一行数据:" + excelDictDTO.getName());
        excelDictDTOList.add(excelDictDTO);
        if (excelDictDTOList.size() == 5) {
            dictMapper.insertBatch(excelDictDTOList);
            excelDictDTOList.clear(); //将数据插入到数据库的同时,也要清空暂时的容器excelDictDTOList
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.print("收尾工作!,还剩 "  );
        System.out.print(excelDictDTOList.size());
        System.out.println(" 条数据,不足5条,需要单独插入");
        dictMapper.insertBatch(excelDictDTOList);
        System.out.println("插入完成~");
        System.out.println("读取完了所有的数据~~~~~~~");
    }
}
