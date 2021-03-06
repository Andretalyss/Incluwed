package com.incluwed.incluwed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class IncluwedApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncluwedApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://3.88.157.51:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS",  "HEAD", "TRACE", "CONNECT");
    }
        };
    }

}
