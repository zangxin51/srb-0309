package com.atguigu.srb.core.controller.admin;


import com.atguigu.srb.base.result.R;
import com.atguigu.srb.base.result.ResponseEnum;
import com.atguigu.srb.common.exception.Assert;
import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
@RestController
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理")
@Slf4j
@CrossOrigin
public class IntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @GetMapping("/list")
    @ApiOperation("积分等级列表")
    public R list() {
        //int a = 1/0;
        log.trace("trace");
        log.debug("debug");
        log.info("information");
        log.warn("warn");
        log.error("error");
        List<IntegralGrade> integralGradeList = integralGradeService.list();
        return R.ok().data("list", integralGradeList);
    }

    @GetMapping("/getById/{id}")
    @ApiOperation("根据id获取积分等级record")
    public R getById(@ApiParam(value = "数据id", required = true, example = "2")
                     @PathVariable Integer id) {
        IntegralGrade integralGrade = integralGradeService.getById(id);
        return R.ok().data("record", integralGrade);
    }

    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/removeById/{id}")
    public R removeById(@ApiParam(value = "数据id", required = true, example = "2")
                              @PathVariable("id") Long id) {
        boolean b = integralGradeService.removeById(id);
        return R.ok().data("result", b);
    }

    @ApiOperation("根据id更新积分等级")
    @PutMapping("/updateById")
    public R updateById(@RequestBody IntegralGrade integralGrade) {
        boolean b = integralGradeService.updateById(integralGrade);
        return R.ok().data("result", b);
    }

    @ApiOperation("保存积分等级")
    @PostMapping("/save")
    public R save(@RequestBody IntegralGrade integralGrade) {
        Integer integralStart = integralGrade.getIntegralStart();
        Integer integralEnd = integralGrade.getIntegralEnd();
        BigDecimal borrowAmount = integralGrade.getBorrowAmount();
        Assert.notNull(integralStart, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.notNull(integralEnd, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.notNull(borrowAmount, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);

        Assert.isTrue(integralStart > 0, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.isTrue(integralEnd > 0, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.isTrue(borrowAmount.intValue()>0, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        Assert.isTrue(integralEnd > integralStart, ResponseEnum.BORROW_AMOUNT_NULL_ERROR);



        boolean save = integralGradeService.save(integralGrade);
        return R.ok().data("result", save);
    }

}

