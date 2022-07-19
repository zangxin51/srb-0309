package com.atguigu.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.srb.core.easyexcel.event.ExcelDictDTOListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.atguigu.srb.core.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
@SuppressWarnings("all")
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public void importFile(MultipartFile multipartFile) {
        try {
            EasyExcel.read(multipartFile.getInputStream(), ExcelDictDTO.class,
                    new ExcelDictDTOListener(dictMapper)).sheet("数据字典").doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExcelDictDTO> getExcelDictDTOs() {
        List<Dict> dictList = dictMapper.selectList(null);
        //将Dict对象 map |--> ExcelDictDTO对象
        List<ExcelDictDTO> collect = dictList.stream()
                .map(dict -> {
                    ExcelDictDTO excelDictDTO = new ExcelDictDTO();
                    BeanUtils.copyProperties(dict, excelDictDTO);
                    return excelDictDTO;
                }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Dict> getDictListByParentId(Long parentId) {
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.eq("parent_id", parentId);
        List<Dict> dictList = dictMapper.selectList(dictQueryWrapper);
        for (Dict dict : dictList) {
            Long id = dict.getId();
            QueryWrapper<Dict> dictQueryWrapper1 = new QueryWrapper<>();
            dictQueryWrapper1.eq("parent_id", id);
            Integer integer = dictMapper.selectCount(dictQueryWrapper1);
            if (integer <= 0) {
                dict.setHasChildren(false);
            }
        }
        return dictList;
    }

}
