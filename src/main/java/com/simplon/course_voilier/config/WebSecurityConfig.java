package com.simplon.course_voilier.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Qualifier("adminService")
	@Autowired
	UserDetailsService uds;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/js/**","/css/**").permitAll()
		    .antMatchers("/admin/**").authenticated()
		    .and()
		    .formLogin().loginPage("/admin").defaultSuccessUrl("/admin/index").permitAll()
		    .and()
		    .logout().permitAll();
//	     http.headers()
//             .xssProtection()
//             .and()
//             .contentSecurityPolicy("script-src 'self'");
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(uds);
	}
}
