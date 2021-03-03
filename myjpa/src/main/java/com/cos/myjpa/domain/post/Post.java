package com.cos.myjpa.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Post {
	@Id  // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // Table, auto_increment, Sequence
	private Long id;
	@Column(length = 60, nullable = false) // 20자로 제한, null값 허용x
	private String title;
	@Lob // 대용량 데이터
	private String content;
	
	
	// 누가 적었는지?
	
	
	@CreationTimestamp // 자동으로 현재시간이 들어감.
	private LocalDateTime createDate; // 만들어진 시간
}
