package com.cos.wtex1.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.wtex1.domain.User;
import com.cos.wtex1.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class RestApiController {
	
	private final UserRepository userRepository;

	@GetMapping({"","/"}) 
	public String home( ) {
		return "<h1>Home</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>User</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Admin</h1>";
	}
	
	@PostMapping("/join")
	public User join(@RequestBody User user) {
		user.setRole("USER");
		return userRepository.save(user);
	}
}
