<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>


<br/>
<div class="container">
	<h2>야구장 등록</h2>
	<br/>
	<form action="/saveStadium" method="POST">
		<div class="form-group">
			<label>구장:</label> 
			<input type="text" class="form-control"  	placeholder="Enter stadium name" name="stadiumName">
		</div>
	
		<div class="form-group">
			<label>팀:</label> 
			<input type="text" class="form-control" placeholder="Enter team" name="teamId">
			<span>1: 기아, 2: 롯데, 3: NC</span>
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>

</body>
</html>