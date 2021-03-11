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

import com.sun.xml.bind.v2.runtime.output.Encoded;

@EnableWebSecurity
@Configuration // IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and().formLogin()
				.loginPage("/loginForm") // form은 x-www-urlencoded
				.loginProcessingUrl("/login")
//				.successHandler(new AuthenticationSuccessHandler() {
//
//					@Override
//					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//							Authentication authentication) throws IOException, ServletException {
//						response.sendRedirect("/");
//
//					}
//				});
				.defaultSuccessUrl("/"); // 로그인이 성공하면 이동하는 페이지
	}
}
