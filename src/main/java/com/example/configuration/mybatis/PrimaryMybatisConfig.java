package com.example.configuration.mybatis;

import com.example.entity.primary.Person;
import com.example.mapper.primary.PersonMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;

@Configuration
@MapperScan(basePackageClasses = PersonMapper.class,
        sqlSessionFactoryRef = "primarySqlSessionFactory",
        sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryMybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
//    @Primary
    public SqlSessionFactory primarySqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource("classpath:/mybatis.xml"));
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/primary/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate primarySqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(primarySqlSessionFactory());
    }
}
