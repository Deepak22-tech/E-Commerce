package com.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private customAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Bean
	public UserDetailsService getUserDetails() {
		return new UserServiceDetailImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		 http.csrf().disable() // Disable CSRF protection
         .authorizeRequests() // Start configuring authorization
         	 .requestMatchers("/admin").hasRole("ADMIN")
         	 .requestMatchers("adminHome").hasRole("ADMIN")
             .requestMatchers("/register").permitAll() // Allow access to the register URL without authentication
             .requestMatchers("/registerProcess").permitAll()
             .requestMatchers("/login").permitAll()
             .requestMatchers("/index").permitAll()
             .requestMatchers("/Cart").permitAll()
             .requestMatchers("/js/**").permitAll()
             .requestMatchers("/images/**").permitAll()
             .anyRequest().authenticated() // Require authentication for any other request
         .and()
         .formLogin().loginPage("/login").successHandler(customAuthenticationSuccessHandler);
		
		return http.build();
	}


}
