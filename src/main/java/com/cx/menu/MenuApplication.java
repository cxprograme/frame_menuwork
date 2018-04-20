package com.cx.menu;

import org.apache.catalina.filters.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.cx.menu.controller","com.cx.menu.dao","com.cx.menu.service","com.cx.menu.entity","com.cx.menu.service.serviceImp"})
@MapperScan("com.cx.menu.dao")
public class MenuApplication {


	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}

}
