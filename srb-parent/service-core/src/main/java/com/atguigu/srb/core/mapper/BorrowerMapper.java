package com.atguigu.srb.core.mapper;

import com.atguigu.srb.core.pojo.entity.Borrower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 借款人 Mapper 接口
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */

@Mapper
public interface BorrowerMapper extends BaseMapper<Borrower> {
    /**
     * 测试自己的list方法:列出所有borrow所有记录
     * @return
     */
    List<Borrower> myList();

}
