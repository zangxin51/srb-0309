package com.atguigu.srb.mybatisplus;

import com.atguigu.srb.mybatisplus.mapper.UserMapper;
import com.atguigu.srb.mybatisplus.pojo.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName WrapperTest.java
 * @Description TODO
 * @createTime 2022年07月10日 23:07:00
 */
@SpringBootTest
public class WrapperTest {

    /**
     * 2、例10：Update - 需求同例4
     * 4 查询名字中包含n，且（年龄小于18或email为空的用户）。
     *   并将这些用户的年龄设置为18，邮箱设置为 user@atguigu.com
     */
    @Test
    public void test10(){
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper
                .set(User::getAge, 18)
                .set(User::getEmail, "user@atguigu.com")
                .like(User::getName, "n")
                .and(query -> query
                        .lt(User::getAge, 18)
                        .or()
                        .isNull(User::getEmail));
        int update = userMapper.update(new User(),userLambdaUpdateWrapper);
        User user = userMapper.selectById(1);
        System.out.println(user);


    }

    /**
     * 五、LambdaXxxWrapper
     * 1、例9：Query - 需求同例8
     */
    @Test
    public void test09() {
        //定义查询条件，有可能为null（用户未输入）
        String name = "n";
        Integer ageBegin = 10;
        Integer ageEnd = 20;

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda()
                .like(StringUtils.isNotBlank(name), User::getName, name)
                .gt(ageBegin != null, User::getAge, ageBegin)
                .lt(ageEnd != null, User::getAge, ageEnd);

        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);

    }

    /**
     * 更简单的方法
     * <p>
     * 四、condition
     * 例8：动态组装查询条件
     * 查询名字中包含n，年龄大于10且小于20的用户，查询条件来源于用户输入，是可选的
     * select * from user where name like '%n%' and age > 10 and age < 20;
     * 定义查询条件，有可能为null（用户未输入）
     */
    @Test
    public void test08_1() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //定义查询条件，有可能为null（用户未输入）
        //本质上相当于mybatis的动态SQL
        String name = null;
        Integer ageBegin = 10;
        Integer ageEnd = 20;

        userQueryWrapper
                .like(StringUtils.isNotBlank(name), "name", name)
                .gt(ageBegin != null, "age", ageBegin)
                .lt(ageEnd != null, "age", ageEnd);

        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);

    }

    /**
     * 四、condition
     * 例8：动态组装查询条件
     * 查询名字中包含n，年龄大于10且小于20的用户，查询条件来源于用户输入，是可选的
     * select * from user where name like '%n%' and age > 10 and age < 20;
     * 定义查询条件，有可能为null（用户未输入）
     */
    @Test
    public void test08() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        String name = null;
        Integer ageBegin = 10;
        Integer ageEnd = 20;
        //定义查询条件，有可能为null（用户未输入）
        if (StringUtils.isNotBlank(name)) {
            userQueryWrapper.like("name", name);
        }

        if (ageBegin != null) {
            userQueryWrapper.gt("age", ageBegin);
        }

        if (ageEnd != null) {
            userQueryWrapper.lt("age", ageEnd);
        }

        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);


    }

    @Test
    /**
     * 三、UpdateWrapper
     * 例7：需求同例4
     * 查询名字中包含n，且（年龄小于18或email为空的用户），
     * 并将这些用户的年龄设置为18，邮箱设置为 user@atguigu.com
     */
    public void test07() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .set("age", 18)
                .set("email", "user@atguigu.com")
                .like("name", "n")
                .and(wrapper -> wrapper.lt("age", 18)
                        .or()
                        .isNull("email"));

        //这里必须要创建User对象，否则无法应用自动填充。如果没有自动填充，可以设置为null
        User user = new User();
        int update = userMapper.update(user, userUpdateWrapper);
        System.out.println("受影响的行数" + update);
    }

    /**
     * 另一种实现方式:杜绝SQL注入:只要有where子句就可以注入
     * 6、例6：实现子查询
     * 查询id不大于3的所有用户的id列表
     * select * from user where id in (select id from user where id <= 3);
     */
    @Test
    public void test06_1() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.in("id", Arrays.asList(1, 2, 3));
//        userQueryWrapper.le("id", 3);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);

    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 6、例6：实现子查询
     * 查询id不大于3的所有用户的id列表
     * select * from user where id in (select id from user where id <= 3);
     * what the fk! select * from user where id <= 3 岂不是更好,但是为了演示所谓的子查询
     * 这个蹩脚的例子真的是 shit.
     */
    @Test
    public void test06() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id", "select id from user where id <= 3");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);
    }

    /**
     * 查询所有用户的用户名和年龄
     */
    @Test
    public void test05() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.err::println);
        /**
         * result: print to console
         * {name=Jone, age=18}
         * {name=Jack, age=20}
         * {name=Tom, age=28}
         * {name=Sandy, age=21}
         * {name=Billie, age=24}
         * {name=安培小三, age=78}
         * {name=安培小三, age=78}
         * {name=安培小三, age=78}
         */

    }

    /**
     * 4 查询名字中包含n，且（年龄小于18或email为空的用户）。
     * 并将这些用户的年龄设置为18，邮箱设置为 user@atguigu.com
     */
    @Test
    public void test04() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name", "n")
                .and(wrapper -> wrapper.lt("age", 18)
                        .or()
                        .isNull("email"));
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int update = userMapper.update(user, userUpdateWrapper);
        System.out.println("受影响的行数:" + update);

    }

    /**
     * 3 删除email为空的用户
     */
    @Test
    public void test03() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println("受影响的行数: " + delete);

    }

    /**
     * 按年龄降序查询用户，如果年龄相同则按id降序排列
     */
    @Test
    public void test02() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age")
                .orderByDesc("id");

        List<User> userList = userMapper.selectList(userQueryWrapper);

        userList.forEach(System.err::println
        );
    }


    /**
     * 1 查询名字中包含n，年龄大于等于10且小于等于20，email不为空的用户
     * 交集查询，所有条件都是交集
     */
    @Test
    public void test01() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name", "n")
                .ge("age", 10)
                .le("age", 20)
                .isNotNull("email");

        List<User> userList = userMapper.selectList(userQueryWrapper);
        userList.forEach(System.err::println);
    }
}
