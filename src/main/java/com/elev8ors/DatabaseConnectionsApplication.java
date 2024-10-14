package com.elev8ors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
//@EnableJpaRepositories(basePackages = {"com.elev8ors.repository"})
public class DatabaseConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConnectionsApplication.class, args);
	}

}
