package com.lauracarpaciu.entities.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableAutoConfiguration
@ComponentScan(basePackages="com.lauracarpaciu.entities.App")
@EnableJpaRepositories("com.lauracarpaciu.dao")
@SpringBootApplication
@EnableJpaAuditing
public class GestiuneApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiuneApplication.class, args);
	}
}
