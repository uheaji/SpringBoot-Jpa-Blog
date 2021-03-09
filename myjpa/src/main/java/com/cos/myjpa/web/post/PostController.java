package com.cos.myjpa.web.post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.post.PostRepository;
import com.cos.myjpa.domain.user.User;
import com.cos.myjpa.service.PostService;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.post.dto.PostRespDto;
import com.cos.myjpa.web.post.dto.PostSaveReqDto;
import com.cos.myjpa.web.post.dto.PostUpdateReqDto;

import lombok.RequiredArgsConstructor;

/**
 * ORM = Object Relation Mapping (자바 오브젝트를 먼저 만들고 DB에 테이블을 자동생성, 자바 오브젝트로 연관관계를
 * 맺을 수 있음) JPA = 자바 오브젝트를 영구적으로 저장하기 위한 인터페이스(함수)
 *
 */
@RequiredArgsConstructor
@RestController
public class PostController {

	private final PostRepository postRepository; // DI
	private final PostService postService;
	private final HttpSession session;
	private final EntityManager em;

	 // 인증만 필요
	@PostMapping("/post")
	public CommonRespDto<?> save(@RequestBody PostSaveReqDto postSaveReqDto) { // title, content
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			return new CommonRespDto<>(-1, "실패", null);
		}
		
		return new CommonRespDto<>(1, "성공", postService.글쓰기(postSaveReqDto, principal));
	}

	 // 인증만 필요
	// http://localhost:8080/post/1
	@GetMapping("/post/{id}")
	public CommonRespDto<?> findById(@PathVariable Long id) {
		return new CommonRespDto<>(1, "성공", postService.한건찾기(id)); // MessageConveter가 모든 getter를 다 호출해서 JSON으로 만들어준다.
	}

	 // 인증만 필요
	@GetMapping("/post")
	public CommonRespDto<?> findAll() {
		return new CommonRespDto<>(1, "성공", postService.전체찾기());
	}

	// 인증(Authentication) 필요 + 권한(Authorization)이 필요하다!
	@PutMapping("/post/{id}")
	public CommonRespDto<?> update(@PathVariable Long id, @RequestBody PostUpdateReqDto postUpdateReqDto) {
		return new CommonRespDto<>(1, "성공", postService.글수정하기(id, postUpdateReqDto));
	}

	// 인증(Authentication) 필요 + 권한(Authorization)이 필요하다!
	@DeleteMapping("/post/{id}")
	public CommonRespDto<?> deleteById(@PathVariable Long id) { // 성공하면 리턴x, 실패하면 illegalexception 발생
		postService.글삭제하기(id);
		return new CommonRespDto<>(1, "성공", null);
	}

}
