package com.incluwed.incluwed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class IncluwedApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncluwedApplication.class, args);
	}

}
