package com.example.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = {"${spring.data.jpa.repository.packages}"}
)
public class DataSourceConfig {

    @Primary
    @Bean(name = "appDataSource")
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource appDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    @ConfigurationProperties(prefix = "spring.data.jpa.entity")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("appDataSource") EntityManagerFactoryBuilder builder, DataSource appDataSource
    ) {
        return builder.dataSource(appDataSource).build();
    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
//    ) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }


//    @Bean
//    @ConfigurationProperties(prefix = "security.datasource")
//    public DataSource securityDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "customUserDataSource")
    @ConfigurationProperties(prefix = "dbuser.datasource")
    public DataSource customUserDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "userEntityManagerFactory")
//    @ConfigurationProperties(prefix = "some.data.entity.user")
//    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("customUserDataSource") DataSource dataSource
//    ) {
//        return builder.dataSource(dataSource).build();
//    }


//    @Primary
//    @Bean
//    @Autowired
//    DataSourceTransactionManager employeeTransactionManager(
//            @Qualifier("appDataSource") DataSource dataSource
//    ) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//



}
