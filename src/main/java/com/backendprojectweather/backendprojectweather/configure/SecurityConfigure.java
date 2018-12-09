package com.backendprojectweather.backendprojectweather.configure;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/h2").permitAll().and().httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		//http.authorizeRequests().antMatchers("/h2").permitAll().and().csrf().disable().formLogin().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT username,decode(password,'base64'),enabled FROM USER WHERE username=?").
		//authoritiesByUsernameQuery("SELECT username, role FROM ROLE WHERE username=?");*/
		auth.inMemoryAuthentication().withUser("nandy@yahoo.in").password("{noop}12345").roles("USER");
	}	
}

