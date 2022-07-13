package com.atguigu.srb.core.controller.front;


import com.atguigu.srb.core.pojo.entity.Borrower;
import com.atguigu.srb.core.service.BorrowerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 借款人 前端控制器
 * </p>
 *
 * @author cqs
 * @since 2022-07-13
 */
@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping("/list")
    public List<Borrower> list() {
        return borrowerService.list();
    }

    @RequestMapping("/create")
    public Borrower create() {
        Borrower borrower = new Borrower();
        borrower.setName("test");
        borrowerService.save(borrower);
        return borrower;
    }

    @RequestMapping("/remove")
    public Borrower remove() {
        QueryWrapper<Borrower> borrowerQueryWrapper = new QueryWrapper<>();
        borrowerQueryWrapper.eq("name", "test");
        boolean remove = borrowerService.remove(borrowerQueryWrapper);
        System.out.println("删除是否成功:" + remove);
        return new Borrower();
    }

    @RequestMapping("/update")
    public Borrower update() {
        UpdateWrapper<Borrower> borrowerUpdateWrapper = new UpdateWrapper<>();
        borrowerUpdateWrapper
                .eq("name", "zangxinTest");

        Borrower borrower = new Borrower();
        borrower.setName("zangxinTest");
        boolean update = borrowerService.update(borrower,borrowerUpdateWrapper);

        System.out.println("update是否成功:" + update);
        return new Borrower();
    }

}

