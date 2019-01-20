package com.azimka.multipledatasoursespring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.azimka.multipledatasoursespring.db2.repository",
        repositoryImplementationPostfix = "db2EntityManagerFactory")
public class DB2Configuration {

    @Bean("db2DataSource")
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createEntityManager(@Qualifier("db2DataSource") DataSource dataSource, EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(dataSource)
                .persistenceUnit("db2")
                .packages("com.azimka.multipledatasoursespring.db2")
                .build();
    }

    @Bean("db2TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
