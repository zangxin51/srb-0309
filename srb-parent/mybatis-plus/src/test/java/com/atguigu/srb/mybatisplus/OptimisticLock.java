package com.atguigu.srb.mybatisplus;

import com.atguigu.srb.mybatisplus.mapper.ProductMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName OptimisticLock.java
 * @Description TODO
 * @createTime 2022年07月10日 22:46:00
 */

@SpringBootTest
public class OptimisticLock {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test01(){
        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        // 小王查询商品价格
        Product productWang  = productMapper.selectById(1);

        // 小李修改商品价格: 提价50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        // 小王修改商品价格: 降价30
        productWang.setPrice(productWang.getPrice() -30);
        productMapper.updateById(productWang);

        // 商品最终价格
        Product product = productMapper.selectById(1);
        System.out.println("最终的价格: " + product.getPrice());

    }
}

















