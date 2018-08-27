package com.cx.common;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cx on 18/7/11.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    /**
     * - 设置SqlSessionFactory；
     * - 设置dao所在的package路径；
     * - 关联注解在dao类上的Annotation名字；
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
        mapperScannerConfigurer.setBasePackage("com.cx.menu.dao");
        mapperScannerConfigurer.setAnnotationClass(MenuRepository.class);
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory2");
        mapperScannerConfigurer.setBasePackage("com.cx.novel.dao");
        mapperScannerConfigurer.setAnnotationClass(NovelRepository.class);
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer3() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory3");
        mapperScannerConfigurer.setBasePackage("com.cx.hslib.dao");
        mapperScannerConfigurer.setAnnotationClass(HsLibRepository.class);
        return mapperScannerConfigurer;
    }
}
