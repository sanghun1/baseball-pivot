<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>팀 이름</th>
				<th>구장</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams }">
				<tr id="team-${team.id }">
					<td>${team.id }</td>
					<td>${team.name }</td>
					<td>${team.stadium.name }</td>
					<td><button type="button" class="btn btn-danger"
							onClick="deleteTeam(${team.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function deleteTeam(id){
		$.ajax({
			type:"DELETE",
			url:"/team/"+id,
			dataType:"json"
	  }).done((res)=>{
			console.log(res);
		    if(res.statusCode===1){
				$("#team-"+id).remove();
			} else {
				alert("수정에 실패하였습니다.");
			}
	  });
	}
</script>
</body>
</html>