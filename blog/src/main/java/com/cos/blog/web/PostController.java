package com.cos.blog.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.service.PostService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.post.dto.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {

	private final PostService postService;

	@GetMapping("/")
	public String findAll(Model model,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5) Pageable pageable,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {

		System.out.println("누구로 로그인 됐을까?");
		System.out.println(principalDetails.getAttributes());
		System.out.println(principalDetails.getUsername());
		Page<Post> posts = postService.전체찾기(pageable);
		model.addAttribute("posts", posts);
		return "post/list";
	}

	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}

	@GetMapping("/post/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		Post postEntity = postService.상세보기(id);
		model.addAttribute("post", postEntity);
		return "post/updateForm";
	}

	@DeleteMapping("/post/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		postService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}

	@GetMapping("/post/{id}")
	public String detail(@PathVariable int id, Model model) {
		Post postEntity = postService.상세보기(id);
		model.addAttribute("post", postEntity);
		return "post/detail"; // viewResolver
	}

	@PutMapping("/post/{id}")
	public @ResponseBody CMRespDto<?> update(@PathVariable int id, @RequestBody PostSaveReqDto postSaveReqDto) {
		postService.수정하기(id, postSaveReqDto);
		return new CMRespDto<>(1, null);
	}

	@PostMapping("/post")
	public String save(PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principalDetails.getUser());

		Post postEntity = postService.글쓰기(post); // 영속화된 entity

		if (postEntity == null) {
			return "post/saveForm";
		} else {
			return "redirect:/";
		}
	}
}
