package com.cos.myjpa.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.myjpa.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User { // 유저 한명이 포스트 여러개와 관계 (OneToMany)
	@Id  // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // Table, auto_increment, Sequence
	private Long id;
	private String username;
	private String password;
	private String email;
	@CreationTimestamp
	private LocalDateTime createDate;
	
	// 유저가 쓴 글 가져오기(관계맺기)
	// 테이블에 영향을 끼치면 안된다.  컬럼이 만들어지면 안될 때-> @Transient 사용.
	// 역방향 매핑
	@JsonIgnoreProperties({"user"}) // post 안에 있는 user는 getter때리지 마라!!!
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // 나는 FK의 주인이 아니다. FK는 user변수명이다.
	private List<Post> post; // 쓴 글이 한건이 아닐수도 있기때문에 컬렉션으로 만들기!!
	
}
