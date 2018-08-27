package com.cx.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */

//@MapperScan({"com.cx.menu.dao","com.cx.novel.dao"})
@Configuration
public class MyBatisConfig implements TransactionManagementConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private Environment env;

    /**
     * 创建数据源 一
     * @return
     * @throws Exception
     */
    @Bean(destroyMethod = "close")
    public DataSource myDbSourceOne() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(destroyMethod = "close")
    public DataSource myDbSourceTwo() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc2.driverClassName"));
        props.put("url", env.getProperty("jdbc2.url"));
        props.put("username", env.getProperty("jdbc2.username"));
        props.put("password", env.getProperty("jdbc2.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(destroyMethod = "close")
    public DataSource myDbSourceThree() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc3.driverClassName"));
        props.put("url", env.getProperty("jdbc3.url"));
        props.put("username", env.getProperty("jdbc3.username"));
        props.put("password", env.getProperty("jdbc3.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * 配置SqlSessionFactory：
     * - 创建SqlSessionFactoryBean，并指定一个dataSource；
     * - 设置这个分页插件：https://github.com/pagehelper/Mybatis-PageHelper；
     * - 指定mapper文件的路径；
     */
    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory1() throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(myDbSourceOne());

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
        bean.setPlugins(new Interceptor[]{pageHelper});

        try {
            //指定mapper xml目录
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

            String mybatisConfig = env.getProperty("mybatis.typeAliasesPackage");
            bean.setTypeAliasesPackage(mybatisConfig);
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            String mybatisXml = env.getProperty("mybatis.mapperLocations");
            Resource[] resources = pathMatchingResourcePatternResolver.getResources(mybatisXml);
            bean.setMapperLocations(resources);
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 配置SqlSessionFactory：
     * - 创建SqlSessionFactoryBean，并指定一个dataSource；
     * - 设置这个分页插件：https://github.com/pagehelper/Mybatis-PageHelper；
     * - 指定mapper文件的路径；
     */
    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2() throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(myDbSourceTwo());

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
        bean.setPlugins(new Interceptor[]{pageHelper});

        try {
            //指定mapper xml目录
            String mybatisConfig = env.getProperty("mybatis.typeAliasesPackage");
            bean.setTypeAliasesPackage(mybatisConfig);
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            String mybatisXml = env.getProperty("mybatis.mapperLocations");
            Resource[] resources = pathMatchingResourcePatternResolver.getResources(mybatisXml);
            bean.setMapperLocations(resources);
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 配置SqlSessionFactory：
     * - 创建SqlSessionFactoryBean，并指定一个dataSource；
     * - 设置这个分页插件：https://github.com/pagehelper/Mybatis-PageHelper；
     * - 指定mapper文件的路径；
     */
    @Bean(name = "sqlSessionFactory3")
    public SqlSessionFactory sqlSessionFactory3() throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(myDbSourceThree());

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
        bean.setPlugins(new Interceptor[]{pageHelper});

        try {
            //指定mapper xml目录
            String mybatisConfig = env.getProperty("mybatis.typeAliasesPackage");
            bean.setTypeAliasesPackage(mybatisConfig);
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            String mybatisXml = env.getProperty("mybatis.mapperLocations");
            Resource[] resources = pathMatchingResourcePatternResolver.getResources(mybatisXml);
            bean.setMapperLocations(resources);
            return bean.getObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager dtm1 = null;
        try {
            dtm1 = new DataSourceTransactionManager(myDbSourceOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataSourceTransactionManager dtm2 = null;
        try {
            dtm2 = new DataSourceTransactionManager(myDbSourceTwo());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DataSourceTransactionManager dtm3 = null;
        try {
            dtm3 = new DataSourceTransactionManager(myDbSourceThree());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChainedTransactionManager ctm = new ChainedTransactionManager(dtm1, dtm2,dtm3);
        return ctm;
    }
}
