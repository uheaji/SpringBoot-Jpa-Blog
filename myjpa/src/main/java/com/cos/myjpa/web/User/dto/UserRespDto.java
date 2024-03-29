package com.cos.myjpa.web.User.dto;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.user.User;

import lombok.Data;

@Data
public class UserRespDto {
	private Long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createDate;
	
	public UserRespDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.createDate = user.getCreateDate();
	}
	
}
