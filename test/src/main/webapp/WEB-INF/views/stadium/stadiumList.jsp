<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>구장</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadium" items="${stadiums}">
				<tr id="stadium${stadium.id}">
					<td>${stadium.id }</td>
					<td>${stadium.stadiumName}</td>
					<td>${stadium.team.teamName }</td>
					<td><button type="button" class="btn btn-danger" onClick="deleteStadium(${stadium.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
function deleteStadium(stadiumId) {
	$.ajax({
		type: "DELETE",
		url: "/stadium/" + stadiumId,
		dataType: "json"
	}).done(res => {
		if (res.statusCode == 1) {
			$("#stadium"+stadiumId).remove();
		} else {
		
		}
	});
};
</script>

</body>
</html>