<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<div>
		<button class="btn btn-secondary" onclick="history.go(-1)">뒤로가기</button>
		<c:if test="${post.user.id == principal.user.id}">
			<a href="/post/${post.id}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger" value="${post.id}">삭제</button>
		</c:if>
		<br /> <br />
		<div class="d-flex justify-content-between">
			<span>글 번호: ${post.id }</span> <span>작성자 :${post.user.username}</span>
		</div>
		<hr />
		<div>
			<h3>${post.title}</h3>
		</div>
		<hr />
		<div>
			<h3>${post.content}</h3>
		</div>
	</div>

	<!-- 댓글 시작 -->
	<div class="card">
		<form>
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
	<br />
	
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply-box" class="list-group">

			<li id="reply-1" class="list-group-item d-flex justify-content-between">
				<div>댓글 내용</div>
				<div class="d-flex">
					<div class="font-italic">작성자 : 작성자이름 &nbsp;</div>
					<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="badge">삭제</button>
				</div>
			</li>
		</ul>
	</div>
	<!-- 댓글 끝 -->
</div>

<script>
	$("#btn-delete").on("click", (e) => {
		let id= e.currentTarget.value;
		
		$.ajax({
			type:"DELETE",
			url:"/post/" + id,
			dataType:"json"
		}).done(res=> {
			if(res.statusCode ===1){
				alert("삭제에 성공하였습니다.");
				history.go(-1);
			} else {
				alert("삭제에 실패하였습니다.");
			}
		});
	});
</script>
<%@include file="../layout/footer.jsp"%>