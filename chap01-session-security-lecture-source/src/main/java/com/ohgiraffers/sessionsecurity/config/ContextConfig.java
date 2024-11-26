package com.ohgiraffers.sessionsecurity.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ohgiraffers.sessionsecurity")
@MapperScan(basePackages = "com.ohgiraffers.sessionsecurity", annotationClass = Mapper.class)
public class ContextConfig {
}
