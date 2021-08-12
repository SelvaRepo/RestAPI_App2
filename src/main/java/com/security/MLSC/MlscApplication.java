package com.security.MLSC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.*"})
public class MlscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlscApplication.class, args);
	}

}
