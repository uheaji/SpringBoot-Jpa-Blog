package com.cos.myjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.post.PostRepository;
import com.cos.myjpa.domain.user.User;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.post.dto.PostRespDto;
import com.cos.myjpa.web.post.dto.PostSaveReqDto;
import com.cos.myjpa.web.post.dto.PostUpdateReqDto;

import lombok.RequiredArgsConstructor;


// JPA 영속성 컨텍스트는 변경 감지를 하는데 언제 하느냐? => 서비스 종료시에 함!

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public Post 글쓰기(PostSaveReqDto postSaveReqDto, User principal) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principal); // FK를 insert 할 수 있다.
		Post postEntity = postRepository.save(post); // 실패하면 => exception을 탄다.
		
		return postEntity;
	}

	@Transactional
	public  Post 글수정하기(Long id, PostUpdateReqDto postUpdateReqDto) {
//		Post p = new Post();
//		em.persist(p);
//		em.createNativeQuery("select * from post");
		
		// 영속화
		Post postEntity = postRepository.findById(id).orElseThrow(() -> { // id를 못찾으면 수정 할 필요 x
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		
		// 영속화시켜서 postUpdateReqDto.toEntity()하지 않고 값을 postEntity에 넣은 이유는 
		// -> id가 없어서 insert가 되기 때문이다.
		postEntity.setTitle(postUpdateReqDto.getTitle());
		postEntity.setContent(postUpdateReqDto.getContent());
		
		return postEntity;
	} // 트랜잭셕 종료시에 영속성 컨택스트에 영속화 되어있는 모든 객체의 변경을 감지하여 변경된 아이들을 flush한다. (commit) = 더티체킹

	@Transactional
	public void 글삭제하기(Long id) {
		postRepository.deleteById(id);
	}

	@Transactional(readOnly = true)  // 변경감지를 수행하지 않는다.(고립성) -> select는 데이터 변경을 하기 않기때문이다. 
	public PostRespDto 한건찾기(Long id) {
		// Optional 1. get() / 2. orElseGet() / 3. orElseThrow()
		Post postEntity = postRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("id를 찾을 수 없습니다.");
		});
		PostRespDto postRespDto = new PostRespDto(postEntity); // user빼고 post만!!
		return postRespDto;
	}

	@Transactional(readOnly = true) 
	public List<Post> 전체찾기() {
		List<Post> postEntity = postRepository.findAll();
		return postEntity;
	}

}
