<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 대시보드</title>
	<style>
		body {
			width: 1200px;
			margin: 0 auto;
			padding: 20px;
			font-family: Arial, sans-serif;
		}

		.header {
			display: flex;
			gap: 10px;
			margin-bottom: 30px;
			flex-wrap: wrap;
		}

		.menu {
			display: flex;
			gap: 10px;
			margin-bottom: 30px;
			flex-wrap: wrap;
		}

		.menu a {
			padding: 10px 15px;
			border: 1px solid #ddd;
			border-radius: 5px;
			text-decoration: none;
			color: #333;
			background: #fafafa;
		}

		.card-wrap {
			display: grid;
			grid-template-columns: repeat(4, 1fr);
			gap: 15px;
			margin-bottom: 30px;
		}

		.card {
			border: 1px solid #ddd;
			border-radius: 8px;
			padding: 20px;
			background: #fafafa;
		}

		.card-title {
			font-size: 14px;
			color: #777;
			margin-bottom: 10px;
		}

		.card-value {
			font-size: 30px;
			font-weight: bold;
		}

		.logout-btn {
			padding: 8px 12px;
			cursor: pointer;
		}
	</style>
</head>
<body>

	<div class="header">
		<h2>관리자 대시보드</h2>

		<form action="/admin/logout" method="post">
			<button type="submit" class="logout-btn">로그아웃</button>
		</form>
	</div>

	<div class="menu">
		<a href="/admin">대시보드</a>
		<a href="/admin/members">회원 관리</a>
		<a href="/admin/boards">게시글 관리</a>
		<a href="/admin/replies">댓글 관리</a>
		<a href="/admin/categories">카테고리 관리</a>
		<a href="/admin/statistics">통계</a>
		<a href="/admin/admins">관리자 관리</a>
		<a href="/admin/logs">운영 로그</a>
	</div>

	<h3>전체 현황</h3>
	<div class="card-wrap">
		<div class="card">
			<div class="card-title">전체 회원 수</div>
			<div class="card-value">${dashboard.totalMemberCount}</div>
		</div>

		<div class="card">
			<div class="card-title">전체 게시글 수</div>
			<div class="card-value">${dashboard.totalBoardCount}</div>
		</div>

		<div class="card">
			<div class="card-title">전체 댓글 수</div>
			<div class="card-value">${dashboard.totalReplyCount}</div>
		</div>

		<div class="card">
			<div class="card-title">전체 좋아요 수</div>
			<div class="card-value">${dashboard.totalLikeCount}</div>
		</div>
	</div>
		<h3>이번 달 현황</h3>
		<div class="card-wrap">
		<div class="card">
			<div class="card-title">이번 달 가입자 수</div>
			<div class="card-value">${dashboard.monthMemberCount}</div>
		</div>

		<div class="card">
			<div class="card-title">이번 달 게시글 수</div>
			<div class="card-value">${dashboard.monthBoardCount}</div>
		</div>

		<div class="card">
			<div class="card-title">이번 달 댓글 수</div>
			<div class="card-value">${dashboard.monthReplyCount}</div>
		</div>

		<div class="card">
			<div class="card-title">이번 달 좋아요 수</div>
			<div class="card-value">${dashboard.monthLikeCount}</div>
		</div>
	</div>

</body>
</html>