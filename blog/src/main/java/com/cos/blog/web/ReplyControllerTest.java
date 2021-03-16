package com.cos.blog.web;

import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.domain.reply.ReplyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyControllerTest {
	
	private final ReplyRepository replyRepository;
	private final PostRepository postRepository;
}
