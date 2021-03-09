package com.cos.myjpa.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.myjpa.filter.MyAuthenticationFilter;

// web.xml

@Configuration // 설정파일
public class FilterConfig {
	
	@Bean // 리턴되는 값을 IoC에 등록한다.
	public FilterRegistrationBean<MyAuthenticationFilter> authenticationFilterRegister() {
		// 필터객체가 생성되었다.
		FilterRegistrationBean<MyAuthenticationFilter> bean = new FilterRegistrationBean<>(new MyAuthenticationFilter());
		
		bean.addUrlPatterns("/test"); // 모든주소
		bean.setOrder(0); // 필터 순서, 낮은 숫자가 먼저 실행된다.
		
		
		return bean;
	}
}
