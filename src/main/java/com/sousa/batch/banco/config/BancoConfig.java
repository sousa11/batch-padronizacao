package com.sousa.batch.banco.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties(prefix = "spring")
@MapperScan(basePackages = {"com.sousa.batch"}, sqlSessionFactoryRef = BancoConfig.SQL_SESSION_FACTORY_NAME)
public class BancoConfig {
	
	public static final String SQL_SESSION_FACTORY_NAME = "mySqlSessionFactory";
	
	@Autowired
	private Environment environment;
	
	@Bean(name = "mySqlDataSource")
	public DataSource mySqlDataSource() throws SQLException{
		return DataSourceBuilder.create()
				.driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
				.url(environment.getProperty("spring.datasource.url"))
				.username(environment.getProperty("spring.datasource.username"))
				.password(environment.getProperty("spring.datasource.password"))
				.build();
	}
	
	@Bean(name = BancoConfig.SQL_SESSION_FACTORY_NAME)
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
		
		org.apache.ibatis.session.Configuration ibatisConfiguration = new org.apache.ibatis.session.Configuration();
		ibatisConfiguration.setJdbcTypeForNull(JdbcType.NULL);
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfiguration(ibatisConfiguration);
		sqlSessionFactoryBean.setDataSource(mySqlDataSource());
		
		return sqlSessionFactoryBean.getObject();
	}
}
