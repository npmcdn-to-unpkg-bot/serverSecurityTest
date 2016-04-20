package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				//lade till detta för test!!!
				//.csrf().disable()
				//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				//Lade till det ovan
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/index.html", "/home.html", "/login.html", "/",
						"/bootstrap-3.3.6-dist/css/*",
						"/angular-1.5.3/angular.js",
						"/angular-1.5.3/angular-route.js"


				).permitAll()
				.antMatchers("/admin_r").hasAuthority("ROLE_ADMIN")
				.anyRequest()
				.authenticated().and()
				.authorizeRequests();




//		.antMatchers("/index.html", "/home.html", "/login.html", "/",
//							"/bootstrap-3.3.6-dist/css/*",
//							"/angular-1.5.3/angular.js",
//							"/angular-1.5.3/angular-route.js"
//
//							).permitAll().anyRequest()
	}
}