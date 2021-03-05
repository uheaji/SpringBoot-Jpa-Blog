package com.cos.myjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.myjpa.domain.user.User;
import com.cos.myjpa.domain.user.UserRepository;
import com.cos.myjpa.web.User.dto.UserJoinReqDto;
import com.cos.myjpa.web.User.dto.UserLoginReqDto;
import com.cos.myjpa.web.User.dto.UserRespDto;
import com.cos.myjpa.web.dto.CommonRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Transactional(readOnly = true) 
	public List<UserRespDto> 전체찾기() {
		List<User> userEntity = userRepository.findAll();
		List<UserRespDto> userRespDtos = new ArrayList<>();
		for (User user : userEntity) {
			userRespDtos.add(new UserRespDto(user));
		}
		return userRespDtos;
	}
	
	@Transactional(readOnly = true) 
	public UserRespDto 한건찾기(Long id) {
		User userEntity = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		
		UserRespDto userRespDto = new UserRespDto(userEntity);
		return userRespDto;
	}
	
	@Transactional(readOnly = true) 
	public User 프로파일(Long id) {
		User userEntity = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		return userEntity;
	}
	
	@Transactional
	public User  회원가입(UserJoinReqDto userJoinReqDto) {
		User userEntity = userRepository.save(userJoinReqDto.toEntity());
		return userEntity;
	}
	
	@Transactional(readOnly = true) 
	public User 로그인(UserLoginReqDto userLoginReqDto) {
		User userEntity = userRepository.findByUsernameAndPassword(userLoginReqDto.getUsername(),userLoginReqDto.getPassword());
		return userEntity;
	}
	
	
}
