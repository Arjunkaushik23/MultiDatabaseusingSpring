package com.elev8ors.DBConfig;

import java.util.HashMap;

import javax.sql.DataSource;

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

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = {"com.elev8ors.product" })
@EnableTransactionManagement
public class ProductDBConfig {

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2EntityManagerFactory")
    LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(final EntityManagerFactoryBuilder builder,
                                                                   @Qualifier("db2DataSource") final DataSource dataSource) {

        final HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder.dataSource(dataSource).properties(properties).packages("com.elev8ors.product")
                .persistenceUnit("product").build();
    }

    @Bean(name = "db2TransactionManager")
    PlatformTransactionManager db2TransactionManager(
            @Qualifier("db2EntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
