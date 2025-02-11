package com.example;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.example.beans.Role;
import com.example.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyOnlineApplicationTests {

    @Autowired
    private RoleServiceImpl roleService;

    @Test
    void contextLoads() {
        roleService.save(new Role("管理员"));
        System.out.println("插入成功");
    }

    /**
     * MybatisPlus 代码生成器
     */
    @Test
    public void MPG() {
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 开发人员
        gc.setAuthor("siji")
                // 生成文件的输出目录
                .setOutputDir(projectPath + "/src/main/java")
                // 开启 ActiveRecord 模式
                //.setActiveRecord(true)
                // 是否覆盖已有文件
                .setFileOverride(true)
                // 开启 BaseResultMap
                .setBaseResultMap(true)
                // 指定生成的主键的ID类型
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseColumnList(true);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/study_online?serverTimezone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel)
                // 是否大写命名
                .setCapitalMode(true)
                // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //  【实体】是否为lombok模型（默认 false)
                .setEntityLombokModel(true)
                // 生成 @RestController 控制器
                .setRestControllerStyle(true)
                // 生成字段注解
                .setEntityTableFieldAnnotationEnable(true);
        // 包名配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.example")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapping");
        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(gc)
                .setDataSource(dsc)
                .setStrategy(sc)
                .setPackageInfo(pkConfig);
        // 执行
        ag.execute();
    }

    @Test
    public void test() {
        // 这人居然让我逆序输出, 哈哈哈, 为难我程序猿???
        String peng = "xttzuikeaiofgeva, ixyuakzpxnfbega, jskakwbdvxgahwotbrcagsjxbdhshdgsjwapd. " +
                "inbshfgshdkxbansoxuctebtngkajchevqkfurb";
        StringBuilder sb = new StringBuilder(peng);
        System.out.println(sb.reverse());
    }

    @Test
    public void test01() {
        // 再次拒绝
        String peng = "xttzuikeaiofgeva, ixyuakzpxnfbega, jskakwbdvxgahwotbrcagsjxbdhshdgsjwapd. " +
                "inbshfgshdkxbansoxuctebtngkajchevqkfurb";
        char[] huiFu = peng.toCharArray();
        for (int i = huiFu.length - 1; i > 0; i--) {
            System.out.printf("%s", huiFu[i]);
        }
    }
}
