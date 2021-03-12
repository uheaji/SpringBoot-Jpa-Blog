package com.cos.wtex1.config.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cos.wtex1.web.dto.LoginReqDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

// 토큰 만들어주기
@RequiredArgsConstructor
public class jwtLoginFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	
	// 주소: POST요청으로 /login요청
	public Authentication attemAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
		System.out.println("로그인 요청 옴");
		
		ObjectMapper om = new ObjectMapper();
		LoginReqDto loginReqDto = null;
		
		try {
			loginReqDto = om.readValue(request.getInputStream(), LoginReqDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 1.  UsernamePassword 토큰 만들기
		UsernamePasswordAuthenticationToken authToken =
				new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());
		// 2. AuthenticationManager에게 토큰을 전달하면 -> 자동으로 UserDetailsService가 호출 => 응답을 Authentication
		authenticationManager.authenticate(authToken);
		
		return null;
	}
	
}
