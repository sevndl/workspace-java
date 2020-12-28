package com.animoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class AnimozApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimozApplication.class, args);
	}

}
