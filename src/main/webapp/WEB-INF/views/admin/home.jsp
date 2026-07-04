<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 홈</title>
</head>
<body>
	<h2>관리자 홈</h2>
	<p>관리자 로그인 성공</p>

	<ul>
		<li><a href="/admin">대시보드</a></li>
		<li><a href="/admin/members">회원 관리</a></li>
		<li><a href="/admin/boards">게시글 관리</a></li>
		<li><a href="/admin/replies">댓글 관리</a></li>
		<li><a href="/admin/categories">카테고리 관리</a></li>
		<li><a href="/admin/statistics">통계</a></li>
		<li><a href="/admin/admins">관리자 관리</a></li>
	</ul>

	<form action="/admin/logout" method="post">
		<button type="submit">로그아웃</button>
	</form>
</body>
</html>