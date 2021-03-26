<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/stadium/stadiumList" method="POST">
		<div class="form-group">
			<label for="name">구장 이름</label> 
			<input type="text" class="form-control" placeholder="이름을 입력하세요." name="name" id="name">
		</div>
		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>
</body>
</html>