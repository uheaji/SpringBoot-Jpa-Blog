<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br/>
<div class="container">
	<h2>선수 등록</h2>
	<br/>
	<form action="/savePlayer" method="POST">
		<div class="form-group">
			<label>선수명:</label> 
			<input type="text" class="form-control"  	placeholder="Enter player name" name="playerName">
		</div>
		<div class="form-group">
			<label>포지션:</label> 
			<input type="text" class="form-control" placeholder="Enter position" name="position">
		</div>
		<div class="form-group">
			<label>소속팀:</label> 
			<input type="text" class="form-control" placeholder="Enter team" name="teamId">
			<span>1: 기아, 2: 롯데, 3: NC</span>
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>

</body>
</html>