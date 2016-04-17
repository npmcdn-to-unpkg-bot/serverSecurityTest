package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsUtils;

@RestController
@SpringBootApplication
public class ServerSecurityTestResourceApplication extends WebSecurityConfigurerAdapter {


	@RequestMapping("/")
	@CrossOrigin(origins = "*", maxAge = 3600,
			allowedHeaders = {"x-auth-token", "x-requested-with"})
	public Message home() {
		System.out.println("Calling hello world resource");
		return new Message("Hello World");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.requestMatchers(CorsUtils::isCorsRequest).permitAll()
				.anyRequest().authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerSecurityTestResourceApplication.class, args);
	}
}
