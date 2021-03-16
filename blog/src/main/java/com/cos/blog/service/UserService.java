package com.cos.blog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;
import com.cos.blog.web.user.dto.UserUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void 회원수정(int id, UserUpdateReqDto userUpdateReqDto) {
		// 영속성컨텍스트에 데이터가 들어오면 사용자가 response응답이 끝나면 사라진다.
		User userEntity = userRepository.findById(id).get(); // 1차 캐시
		String encPassword = bCryptPasswordEncoder.encode(userUpdateReqDto.getPassword());
		
		
		userEntity.setPassword(encPassword);
		userEntity.setEmail(userUpdateReqDto.getEmail());
	} // 업데이트는 더티체킹
	
}
