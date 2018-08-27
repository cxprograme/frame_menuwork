package com.cx;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

//@SpringBootApplication
////@ComponentScan(basePackages = {"com.cx.menu.controller","com.cx.menu.dao","com.cx.menu.service","com.cx.menu.entity","com.cx.menu.service.serviceImp"})
//@MapperScan("com.cx.menu.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration(exclude= {JpaRepositoriesAutoConfiguration.class})
public class MenuApplication {


	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}
	/*@Bean
	PageHelper pageHelper(){
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "pageNum=pageNumKey;pageSize=pageSizeKey;count=countSql");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("dialect","mysql");
		pageHelper.setProperties(properties);

		//添加插件
		new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
		return pageHelper;
	}*/
}
