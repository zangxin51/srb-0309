package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
public interface DictService extends IService<Dict> {
    public void importFile(MultipartFile multipartFile);

    List<ExcelDictDTO> getExcelDictDTOs();

    List<Dict> getDictListByParentId(Long parentId);
}
