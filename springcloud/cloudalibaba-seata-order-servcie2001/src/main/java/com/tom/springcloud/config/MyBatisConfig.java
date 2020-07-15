package com.tom.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tom.springcloud.dao")
public class MyBatisConfig {
}
