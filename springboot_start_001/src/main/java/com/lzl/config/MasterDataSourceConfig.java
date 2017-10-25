package com.lzl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.MASTER_PACKAGE,sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(MasterDataSourceConfig.class);


    static final String  MASTER_PACKAGE = "com.lzl.mapper.book";
    private static final String MASTER_MAPPER_LOCAL = "classpath*:mapper/book/*.xml";


    /** 配置一个主库

     * @return  DruidDataSource

     */
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.datasource")
    public DruidDataSource masterDruidDataSource(){
        return new DruidDataSource();
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(){
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(masterDruidDataSource());

        try {
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MASTER_MAPPER_LOCAL));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("配置主库的SqlSessionFactory失败，error:{}",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(masterDruidDataSource());
    }

}
