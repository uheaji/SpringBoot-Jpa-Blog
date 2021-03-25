package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.reply.ReplyRepository;
import com.cos.blog.domain.user.User;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.reply.dto.ReplySaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyControllerTest {
	
	private final ReplyRepository replyRepository;
	private final PostRepository postRepository;
	
	// 게시글 상세보기(user, post, reply 등)
	@GetMapping("/test/post/{id}")
	public CMRespDto<?> testPost(@PathVariable int id) {
		
		postRepository.findAll();
		
		Post post = postRepository.findById(id).get();
		return new CMRespDto<>(1, post);
	}
	

}
