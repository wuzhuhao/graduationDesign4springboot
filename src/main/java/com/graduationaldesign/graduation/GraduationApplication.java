package com.graduationaldesign.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author wuzhuhao
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.graduationaldesign.graduation.mapper")
public class GraduationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduationApplication.class, args);
    }
}
