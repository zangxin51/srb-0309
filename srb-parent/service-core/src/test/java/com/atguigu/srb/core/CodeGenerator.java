package com.atguigu.srb.core;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cqs
 * @version 1.0.0
 * @ClassName CodeGenerator.java
 * @Description TODO
 * @createTime 2022年07月13日 17:06:00
 */
@SpringBootTest
public class CodeGenerator {

    @Test
    public void codeGenerator(){
        // 1、创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 2、全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("cqs");
        globalConfig.setOpen(true); //生成后是否打开资源管理器
        globalConfig.setServiceName("%sService");//	//去掉Service接口的首字母I
        globalConfig.setIdType(IdType.AUTO);//设置数据库的 auto_increment primary key
        globalConfig.setSwagger2(true);//喀什Swagger2模式
        autoGenerator.setGlobalConfig(globalConfig);
        //3.配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:13306/srb_core?serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=true");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);
        //4.包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.atguigu.srb.core");
        packageConfig.setEntity("pojo.entity");//此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
        autoGenerator.setPackageInfo(packageConfig);
        //5.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);////数据库table_name映射到实体的命名策略:下划线-->驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);////数据库table_column字段映射到实体的命名策略
        strategyConfig.setEntityLombokModel(true);//lombok
        strategyConfig.setLogicDeleteFieldName("is_deleted");//logical deleted
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);////去掉布尔值的is_前缀（确保tinyint(1)）
        strategyConfig.setRestControllerStyle(true);//在controller自动添加注解@RestController
        autoGenerator.setStrategy(strategyConfig);

        //6.执行
        autoGenerator.execute();




    }
}
