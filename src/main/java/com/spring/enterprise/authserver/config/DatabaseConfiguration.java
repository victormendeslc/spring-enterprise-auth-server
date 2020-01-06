package com.spring.enterprise.authserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "com.spring.enterprise.authserver")
@EnableJpaRepositories(basePackages = "com.spring.enterprise.authserver")
public class DatabaseConfiguration {

    public DatabaseConfiguration() {
        log.info("Created");
    }
}
