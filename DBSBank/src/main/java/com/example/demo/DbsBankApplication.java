package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@ComponentScan(basePackages = "com.example.demo.*")
@EntityScan("com.example.demo.domain")
@EnableJpaRepositories("com.example.demo.repository")
public class DbsBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsBankApplication.class, args);
	}
}
