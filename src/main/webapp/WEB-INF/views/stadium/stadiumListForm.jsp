<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>구장</th>
				<th>팀</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stadium" items="${stadiums }">
				<tr id="stadium-${stadium.id }">
					<td>${stadium.id }</td>
					<td>${stadium.name }</td>
					<td>${stadium.team.name }</td>
					<td><button type="button" class="btn btn-danger"
							onClick="deleteStadium(${stadium.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	function deleteStadium(id){
		$.ajax({
			type:"DELETE",
			url:"/stadium/"+id,
			dataType:"json"
	  }).done((res)=>{
			console.log(res);
		    if(res.statusCode===1){
				$("#stadium-"+id).remove();
			} else {
				alert("수정에 실패하였습니다.");
			}
	  });
	}
</script>
</body>
</html>