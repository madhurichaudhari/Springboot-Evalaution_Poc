package com.evaluationtestdemo.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author MadhuriC
 *for creating a k WebSecurityConfigurer
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		        auth.inMemoryAuthentication().withUser("admin@hcl.com").password("root123").roles("ADMIN");
		    
		}

	/**
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		      httpSecurity.authorizeRequests()
		      //.antMatchers("/").access("hasRole('USER') or hasRole('ADMIN')")
		      //.antMatchers("/admin/**").hasRole("ADMIN")
		       .antMatchers("/console/**").permitAll()
		        .and().formLogin().loginPage("/login")
		        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
		      httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}
}




	

