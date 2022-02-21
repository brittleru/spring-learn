//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "userEntityManagerFactory",
//        transactionManagerRef = "userTransactionManager",
//        basePackages = {"${spring.data.jpa.repository.packages}"+".user"}
//)
//public class UserDataSourceConfig {
//
//    @Bean(name = "customUserDataSource")
//    @ConfigurationProperties(prefix = "dbuser.datasource")
//    public DataSource customUserDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "userEntityManagerFactory")
//    @ConfigurationProperties(prefix = "some.data.entity.user")
//    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("customUserDataSource") DataSource dataSource
//    ) {
//        return builder.dataSource(dataSource).build();
//    }
//
//    @Bean(name = "userTransactionManager")
//    public PlatformTransactionManager userTransactionManager(
//            @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(userEntityManagerFactory);
//    }
//
////    @Bean
////    @Autowired
////    DataSourceTransactionManager userTransactionManager(
////            @Qualifier("customUserDataSource") DataSource dataSource
////    ) {
////        return new DataSourceTransactionManager(dataSource);
////    }
//
//}
