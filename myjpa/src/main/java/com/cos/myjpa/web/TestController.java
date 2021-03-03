package com.cos.myjpa.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.post.PostRepository;
import com.cos.myjpa.web.Post.dto.PostSaveReqDto;
import com.cos.myjpa.web.Post.dto.PostUpdateReqDto;
import com.cos.myjpa.web.dto.CommonRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

	private final PostRepository postRepository; // DI

	@PostMapping("/test/post")
	public CommonRespDto<?> save(@RequestBody PostSaveReqDto postSaveReqDto) { // title, content
		Post postEntity = postRepository.save(postSaveReqDto.toEntity()); // 실패하면 => exception을 탄다.
		return new CommonRespDto<>(1, "성공", postEntity);
	}

	@GetMapping("/test/post")
	public CommonRespDto<?> findAll() {
		List<Post> postEntity = postRepository.findAll();
		return new CommonRespDto<>(1, "성공", postEntity);
	}

	@GetMapping("/test/post/{id}")
	public CommonRespDto<?> findById(@PathVariable Long id) {

		Post postEntity = postRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		return new CommonRespDto<>(1, "성공", postEntity);
	}
	
	@PutMapping("/test/post/{id}")
	public CommonRespDto<?> update(@PathVariable Long id, @RequestBody PostUpdateReqDto postUpdateReqDto) { 
		
		Post postEntity = postRepository.findById(id).orElseThrow(() -> { // id를 못찾으면 수정 할 필요 x
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		
		postEntity.setTitle(postUpdateReqDto.getTitle());
		postEntity.setContent(postUpdateReqDto.getContent());
		
		Post postUpdateEntity = postRepository.save(postEntity); // 더티체킹을 사용해야 하는데 그럴려면 @Service 만들어야 가능함@
		
		return new CommonRespDto<>(1, "성공", postUpdateEntity);
	}
	
	@DeleteMapping("/test/post/{id}")
	public CommonRespDto<?> deleteById(@PathVariable Long id) { // 성공하면 리턴x, 실패하면 illegalexception 발생
		postRepository.deleteById(id);
		return new CommonRespDto<>(1, "성공", null);
	}
	
}
