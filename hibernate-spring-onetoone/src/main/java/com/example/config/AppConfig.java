package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

    // DataSource Bean
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds =
                new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        ds.setUrl(
                "jdbc:mysql://localhost:3306/wiprotraining"
        );

        ds.setUsername("root");
        ds.setPassword("Ayush@523");

        return ds;
    }

    // Hibernate Properties
    private Properties hibernateProperties() {

        Properties props = new Properties();

        props.put("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");

        props.put("hibernate.show_sql", "true");

        props.put("hibernate.hbm2ddl.auto", "update");

        return props;
    }

    // SessionFactory Bean
    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean factory =
                new LocalSessionFactoryBean();

        factory.setDataSource(dataSource());

        factory.setPackagesToScan("com.example.model");

        factory.setHibernateProperties(
                hibernateProperties()
        );

        return factory;
    }

    // Transaction Manager
    @Bean
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {

        HibernateTransactionManager tx =
                new HibernateTransactionManager();

        tx.setSessionFactory(sessionFactory);

        return tx;
    }
}