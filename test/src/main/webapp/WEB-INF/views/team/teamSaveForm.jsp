<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br/>
<div class="container">
	<h2>팀 등록</h2>
	<br/>
	<form action="/saveTeam" method="POST">
		<div class="form-group">
			<label>팀명:</label> 
			<input type="text" class="form-control"  	placeholder="Enter team name" name="teamName">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>

</body>
</html>