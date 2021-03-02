package com.cos.myiocdi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Component(용도없음), Configuration(설정파일), Service, Repository, Bean

@RestController
public class PostController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
