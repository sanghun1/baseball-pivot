<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>선수 이름</th>
				<th>포지션</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${players }">
				<tr id="player-${player.id }">
					<td>${player.id }</td>
					<td>${player.name }</td>
					<td>${player.position }</td>
					<td>${player.team.name }</td>
					<td><button type="button" class="btn btn-danger"
							onClick="deletePlayer(${player.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function deletePlayer(id){
		$.ajax({
			type:"DELETE",
			url:"/player/"+id,
			dataType:"json"
	  }).done((res)=>{
			console.log(res);
		    if(res.statusCode===1){
				$("#player-"+id).remove();
			} else {
				alert("수정에 실패하였습니다.");
			}
	  });
	}
</script>
</body>
</html>