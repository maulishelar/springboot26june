package org.com;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Value("${DB_URL}")
	private String URL;
	@Value("${DRIVER_CLASS}")
	private String DRIVER_CLASS;
	@Value("${DB_USERNAME}")
	private String USERNAME;
	@Value("${DB_PASSWORD}")
	private String PASSWORD;
	@Value("${HIBERNATE_DIALECT}")
	private String DIALECT;
	@Value("${HIBERNATE_SHOW_SQL}")
	private String SHOW_SQL;
	@Value("${HIBERNATE_HBM2DDL}")
	private String HBM2DDL;
	@Value("${HIBERNATE_PACKAGE_TO_SCAN}")
	private String PACKAGE_TO_SCAN;
	
	
	@Bean
	public DriverManagerDataSource dataSouces()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
	LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	sessionFactory.setDataSource(dataSouces());
	sessionFactory.setPackagesToScan(PACKAGE_TO_SCAN);
	Properties hibernatePros=new Properties();
	hibernatePros.put("hibernate.dialect",DIALECT);
	hibernatePros.put("hibernate.show_sql",SHOW_SQL);
	hibernatePros.put("hibernate.hbm2ddl.auto",HBM2DDL);
	sessionFactory.setHibernateProperties(hibernatePros);
	return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
}
