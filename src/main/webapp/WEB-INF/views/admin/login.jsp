<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 로그인</title>
</head>
<body>
	<h2>관리자 로그인</h2>

	<% if (request.getParameter("error") != null)  { %>
		<p style="color:red;">관리자 아이디 또는 비밀번호를 확인해주세요.</p>
	<% } %>

	<% if (request.getParameter("logout") != null)  { %>
		<p style="color:green;">로그아웃되었습니다.</p>
	<% } %>

	<form action="/admin/loginPost" method="post">
		<p>
			<label>관리자 ID</label>
			<input type="text" name="adminId" required>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password" required>
		</p>
		<button type="submit">로그인</button>
	</form>
</body>
</html>