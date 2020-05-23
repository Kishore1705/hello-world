package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private AuthenticationEntryPoint authEntryPoint;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("Kishore")
		.password("$2a$10$K65x7/TZEpXlnDGBZSC.5u0R.iO7U1CbkZ.VIIKjSkY8uOBNmeqzK")
		.roles("USER")
		.and()
			.withUser("admin")
			.password("$2a$10$fCY89aAmJCp9kQ5Ejz0HveVzKSBCyGVk6YmgqSp2uzL2kqwJD/zCm")
			.roles("ADMIN")
   ; 
		
	}
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }  
	
	
	
}
