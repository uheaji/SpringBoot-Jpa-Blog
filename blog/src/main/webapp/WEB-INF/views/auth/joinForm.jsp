<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<!-- Page Header -->
<header class="masthead" style="background-image: url('../resources/img/flora.png')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>회원가입</h1>
					<span class="subheading">WELCOME :D</span>
				</div>
			</div>
		</div>
	</div>
</header>

<br />
<div class="container" style="width: 400px;">
	<form action="/join" method="POST">
		<div class="form-group ">
			<input type="text" class="form-control " placeholder="Username" name="username">
		</div>
		<div class="form-group ">
			<input type="password" class="form-control " placeholder="Password" name="password">
		</div>
		<div class="form-group ">
			<input type="email" class="form-control " placeholder="Email" name="email">
		</div>
		<button class="btn btn-primary">회원가입</button>
	</form>

	<span style="font-size: 13px;">이미 회원가입이 되셨나요?</span>
	<a href="/loginForm" style="color: blue; font-size: 13px; font-weight: bold;">로그인</a>

</div>
<br />
<%@ include file="../layout/footer.jsp"%>
</body>
</html>