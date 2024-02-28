package com.greatlearning.EmployeeManagementApplicationSecurity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.EmployeeManagementApplicationSecurity.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		log.info("WebSecurityConfig userDetailsService");
		
		return new UserService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		log.info("WebSecurityConfig passwordEncoder");
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		log.info("WebSecurityConfig authenticationProvider");

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("WebSecurityConfig configure");

		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		log.info("WebSecurityConfig configure(HttpSecurity http)");

		 http	 
	        .antMatcher("/")                                 
	        .authorizeRequests()
	            .anyRequest().hasRole("ADMIN")  
	            .and()  
	        .httpBasic();  
		 
//		 .authorizeHttpRequests()
//		 .antMatchers(HttpMethod.GET, "/").hasAnyAuthority("ADMIN","USER")
//		 .antMatchers(HttpMethod.POST, "/").hasAuthority("ADMIN")
//		 .antMatchers(HttpMethod.DELETE, "/").hasAuthority("ADMIN")
//		 .anyRequest().permitAll()
//		 .and()
//		 .httpBasic();
	}
	
}