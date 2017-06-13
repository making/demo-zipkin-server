package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(-5)
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void init(WebSecurity web) {
		web.ignoring().antMatchers("/*.js", "/*.css", "/*.png", "/*.woff2");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/**") //
				.and() //
				.authorizeRequests() //
				.antMatchers("/login*", "/login/**").permitAll() //
				.anyRequest().hasRole("ADMIN");
	}
}