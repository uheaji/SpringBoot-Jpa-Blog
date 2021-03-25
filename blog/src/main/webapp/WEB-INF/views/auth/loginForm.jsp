<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<!-- Page Header -->
<header class="masthead" style="background-image: url('../resources/img/flora.png')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>로그인</h1>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="container" style="width: 400px">

	<form action="/login" method="POST">
		<div class="form-group ">
			<input type="text" class="form-control " placeholder="Username" name="username">
		</div>
		<div class="form-group ">
			<input type="password" class="form-control " placeholder="Password" name="password">
		</div>
		<button class="btn btn-primary">로그인</button>
	</form>

	<span style="font-size: 13px;">아직 회원가입이 안되셨나요?</span> 
	<a href="/joinForm" style="color: blue; font-size: 13px; font-weight: bold;">회원가입</a> <br /> 
    <a href="/oauth2/authorization/google" style="font-size: 13px;">구글 로그인/</a> 
	<a href="/oauth2/authorization/facebook" style="font-size: 13px;">페이스북 로그인/</a>
	<a href="/oauth2/authorization/naver" style="font-size: 13px;">네이버로그인/</a>
	<a href="/oauth2/authorization/kakao" style="font-size: 13px;">카카오 로그인</a>

</div>

<%@ include file="../layout/footer.jsp"%>