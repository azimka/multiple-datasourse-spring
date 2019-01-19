package com.azimka.multipledatasoursespring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.azimka.multipledatasoursespring.db1")
public class DB1Configuration {

}
