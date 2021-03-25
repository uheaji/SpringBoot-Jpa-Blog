<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br />
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>선수명</th>
				<th>포지션</th>
				<th>소속팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${players}">
				<tr id="player${player.id}">
					<td>${player.id }</td>
					<td>${player.playerName}</td>
					<td>${player.position}</td>
					<td>${player.team.teamName }</td>
					<td><button type="button" class="btn btn-danger" onClick="deletePlayer(${player.id})">삭제</button></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

<script>
function deletePlayer(playerId) {
	$.ajax({
		type: "DELETE",
		url: "/player/" + playerId,
		dataType: "json"
	}).done(res => {
		if (res.statusCode == 1) {
			$("#player"+playerId).remove();
		} else {
		
		}
	});
};
</script>

</body>
</html>