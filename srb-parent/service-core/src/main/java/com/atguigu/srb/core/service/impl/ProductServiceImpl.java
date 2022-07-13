package com.atguigu.srb.core.service.impl;

import com.atguigu.srb.core.pojo.entity.Product;
import com.atguigu.srb.core.mapper.ProductMapper;
import com.atguigu.srb.core.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
