package com.car.manage.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.car.manage.sys.dao")
public class MyBatisConfig {
}
