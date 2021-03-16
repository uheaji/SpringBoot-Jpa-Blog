package com.cos.blog.domain.reply;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply {
	@Id // PK
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable= false, length = 200)
	private String content;
	
	// 유저
	
	// 포스트
	
	@CreationTimestamp
	private Timestamp createDate;

}
