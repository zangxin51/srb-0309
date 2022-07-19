package com.atguigu.srb.core.controller.admin;

import com.alibaba.excel.EasyExcel;
import com.atguigu.srb.base.result.R;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.atguigu.srb.core.service.DictService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/admin/core/dict")
@Api(tags = "数据字典")
@CrossOrigin
@Slf4j
public class AdminDictController {

    @Autowired
    private DictService dictService;

    @GetMapping("/getDictListByParentId/{parentId}")
    public R getDictListByParentId(@PathVariable Long parentId) {
        List<Dict> dictList = dictService.getDictListByParentId(parentId);
        return R.ok().data("list", dictList);
    }
    @PostMapping("/import")
    public R importFile(@RequestParam("file") MultipartFile multipartFile) {
        dictService.importFile(multipartFile);
        return R.ok();
    }

    @GetMapping("/export")
    public void exportFile(HttpServletResponse response) throws UnsupportedEncodingException {
        ServletOutputStream outputStream = null;
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("mydict", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        List<ExcelDictDTO> excelDictDTOList = dictService.getExcelDictDTOs();
        try {
            outputStream = response.getOutputStream();
            EasyExcel.write(outputStream,ExcelDictDTO.class).sheet("导出的数据字典").doWrite(excelDictDTOList);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}
