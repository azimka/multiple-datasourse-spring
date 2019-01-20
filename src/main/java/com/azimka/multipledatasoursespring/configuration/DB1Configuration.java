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
@EnableJpaRepositories(basePackages = "com.azimka.multipledatasoursespring.db1.repository",
        entityManagerFactoryRef = "db1EntityManagerFactory")
public class DB1Configuration {

    @Bean("db1DataSource")
    @ConfigurationProperties(prefix = "db1.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("db1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("db1DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.azimka.multipledatasoursespring.db1.model")
                .persistenceUnit("db1")
                .build();
    }

    @Bean("db1TransactionManager")
    public PlatformTransactionManager createTransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
