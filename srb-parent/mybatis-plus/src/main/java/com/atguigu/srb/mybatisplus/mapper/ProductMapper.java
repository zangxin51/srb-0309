package com.atguigu.srb.mybatisplus.mapper;

import com.atguigu.srb.mybatisplus.pojo.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName ProductMapper.java
 * @Description TODO
 * @createTime 2022年07月10日 22:44:00
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
