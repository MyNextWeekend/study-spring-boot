package com.example.studyspringboot;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/src/main/java";
        String url = "jdbc:mysql://106.55.186.222:3306/study_java?useSSL=false&useUnicode=true&serverTimeZone=GMT%2b8"; // 数据库url
        String username = "study_java";   // 用户名
        String password = "Hd6XsLRGsfNxxTx5";   // 密码
        ArrayList<String> tables = new ArrayList<>();   // 需要生成代码的表有哪些
        tables.add("UserDetails");


        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("MyNextWeekend")    // 设置author
                            .enableSwagger()    // 添加Swagger注解
                            .dateType(DateType.ONLY_DATE) // 设置日期类型
                            .disableOpenDir()
                            .fileOverride()
                            .outputDir(path);  // 设置路径
                })
                .packageConfig(builder -> {
                    builder.parent("generator")  // 包路径
                            .entity("entity")               // 实体包名
                            .service("service")             // service包名
                            .serviceImpl("service.impl")    // service实现类包名
                            .xml("mapper")                  // dao层包名
                            .controller("controller")       // controller包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper"));    // xml映射文件包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("")     // 表前缀

                            .serviceBuilder()               // 构建service
                            .formatServiceFileName("%sService")     // service命名规则
                            .formatServiceImplFileName("%sServiceImpl") // service实现类命名规则

                            .controllerBuilder()        // 构建controller
                            .formatFileName("%sController") // controller命名规则
                            .enableRestStyle() // 驼峰命名

                            .entityBuilder()    // 构建实体类
                            .enableChainModel()
                            .idType(IdType.AUTO)    // id类型
                            .enableLombok()         // lombok
                            .naming(NamingStrategy.underline_to_camel)  // 数据库下划线转为驼峰式命名
                            .logicDeleteColumnName("deleted")       // 逻辑删除字段
                            .versionColumnName("version")           // 乐观锁
                            .addTableFills(new Column("gmt_create", FieldFill.INSERT))      // 新增时填充
                            .addTableFills(new Column("gmt_modified", FieldFill.INSERT_UPDATE)) // 新增或修改时填充
                            .enableTableFieldAnnotation()

                            .mapperBuilder()    // 构建dao层
                            .enableBaseResultMap() // 通用map
                            .superClass(BaseMapper.class)   // 继承 BaseMapper
                            .formatMapperFileName("%sMapper")   // dao层命名规则
                            .formatXmlFileName("%sMapper")  // xml映射文件命名规则
                            .mapperAnnotation(Mapper.class); // dao层添加@Mapper注解
                })
                // .templateEngine(new VelocityTemplateEngine())
                // .templateEngine(new BeetlTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
