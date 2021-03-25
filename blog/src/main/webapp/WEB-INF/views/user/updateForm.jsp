<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- Page Header -->
<header class="masthead" style="background-image: url('../resources/img/flora.png')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>회원정보</h1>
					<span class="subheading">${principal.user.username}님 회원수정 페이지 입니다.</span>
				</div>
			</div>
		</div>
	</div>
</header>


<div class="container" style="width: 400px;">
	<form>
		<input type="hidden" id="id" value="${id}" />
		<div class="form-group ">
			<input type="text" class="form-control " placeholder="Username"
				value="${principal.user.username}" name="username" readonly="readonly">
		</div>
		<div class="form-group ">
			<input type="password" value="" class="form-control " placeholder="Password" name="password">
		</div>
		<div class="form-group ">
			<input type="email" class="form-control " value="${principal.user.email}" placeholder="Email"
				name="email">
		</div>
		<button class="btn btn-primary" id="btn-update">회원수정</button>
	</form>


</div>


<script>
	$("#btn-update").on("click", (e)=> {
		e.preventDefault();
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		let id = $("#id").val();
		console.log(data);
		$.ajax({
			type: "PUT",
			url: "/user/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done((res)=>{
			console.log(res);
			if(res.statusCode === 1){
				alert("수정에 성공하였습니다.");
				location.href = "/";
			}else{
				alert("수정에 실패하였습니다.");
			}
		});
	});
</script>

<%@ include file="../layout/footer.jsp"%>
