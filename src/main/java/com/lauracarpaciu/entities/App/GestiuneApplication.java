package com.lauracarpaciu.entities.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class GestiuneApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiuneApplication.class, args);
	}
}
