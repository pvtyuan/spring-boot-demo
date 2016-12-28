package com.example.configuration.mybatis;

import com.example.mapper.primary.PersonMapper;
import com.example.mapper.secondary.CompanyMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackageClasses = CompanyMapper.class,
        sqlSessionFactoryRef = "secondarySqlSessionFactory",
        sqlSessionTemplateRef = "secondarySqlSessionTemplate")
public class SecondaryMybatisConfig {
    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource dataSource;
    @Bean
    public SqlSessionFactory secondarySqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setConfigLocation(resolver.getResource("classpath:/mybatis.xml"));
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/secondary/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate secondarySqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(secondarySqlSessionFactory());
    }
}
