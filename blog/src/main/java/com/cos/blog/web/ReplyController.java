package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.ReplyService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.reply.dto.ReplySaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyController {

	private final ReplyService replyService;
	
	@DeleteMapping("/reply/{id}")
	public CMRespDto<?> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		// 모든 컨트롤러의 삭제하기, 수정하기는 무조건 동일인물이 로그인했는지 확인해야한다!!
		int result = replyService.삭제하기(id, principalDetails.getUser().getId());
		return new CMRespDto<>(result, null);
	}
	
	@PostMapping("/reply")
	public CMRespDto<?> save(@RequestBody ReplySaveReqDto replySaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		User userEntity = principalDetails.getUser();
		Reply reply = replySaveReqDto.toEntity();
		reply.setUser(userEntity);

		replyService.댓글쓰기(reply, replySaveReqDto.getPostId());
		return new CMRespDto<>(1, null);
	}
	
}
