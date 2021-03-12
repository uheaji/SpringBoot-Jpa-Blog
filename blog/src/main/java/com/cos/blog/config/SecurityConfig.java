package com.cos.blog.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cos.blog.config.oauth.OAuth2DetailsService;
import com.sun.xml.bind.v2.runtime.output.Encoded;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration // IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final OAuth2DetailsService oAuth2DetailsService;

	// IoC등록만 하면 AuthenticationMAnager가 Bcrypt로 자동 검증해줌.
	@Bean
	public BCryptPasswordEncoder Encoded() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/user/**", "/post/**")
				.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") // ROLE_는 강제성이 있음.
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage("/loginForm") // form은 x-www-urlencoded
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.and()
				.oauth2Login()
				.userInfoEndpoint()
				.userService(oAuth2DetailsService); 
	}
}
