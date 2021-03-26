<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/player/playerList" method="POST">
		<div class="form-group">
			<label for="position">포지션</label> <input type="text"
				class="form-control" placeholder="포지션을 입력하세요." name="position"
				id="position">
		</div>
		<div class="form-group">
			<label for="name">선수 이름</label> <input type="text"
				class="form-control" placeholder="이름을 입력하세요." name="name" id="name">
		</div>
		<div class="form-group">
			<select name="teamId" class="custom-select-sm">
				<option selected>팀 선택</option>
				<c:forEach var="team" items="${teams }">
					<option value="${team.id }">${team.name }</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
</body>
</html>