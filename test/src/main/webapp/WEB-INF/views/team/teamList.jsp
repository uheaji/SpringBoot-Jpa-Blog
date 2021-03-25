<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>팀명</th>
				<th>구장</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr  id="team${team.id}">
					<td>${team.id}</td>
					<td>${team.teamName}</td>
					<td>${team.stadium.stadiumName}</td>
					<td><button type="button" class="btn btn-danger" onClick="deleteTeam(${team.id})">삭제</button></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<script>
function deleteTeam(teamId) {
	$.ajax({
		type: "DELETE",
		url: "/team/" + teamId,
		dataType: "json"
	}).done(res => {
		if (res.statusCode == 1) {
			$("#team"+teamId).remove();
		} else {
		
		}
	});
};
</script>

</body>
</html>