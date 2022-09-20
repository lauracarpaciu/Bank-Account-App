package com.lauracarpaciu.entity.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {
        "com.lauracarpaciu.entity.App"
})
@EnableAsync
@EnableAutoConfiguration
@EntityScan("com.lauracarpaciu.entity.*")
@ComponentScan(basePackages = {"com.lauracarpaciu.security", "com.lauracarpaciu.*",})
@EnableJpaRepositories("com.lauracarpaciu.dao")
@EnableJpaAuditing
public class GestiuneApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiuneApplication.class, args);
	}
}
