package com.atguigu.srb.core.mapper;

import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(@Param("excelDictDTOList")List<ExcelDictDTO> excelDictDTOList);
}
