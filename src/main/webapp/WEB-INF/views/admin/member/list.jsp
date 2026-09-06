<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="jakarta.tags.core" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>회원 관리</title>
			<style>
				body {
					width: 1200px;
					margin: 0 auto;
					padding: 20px;
					font-family: Arial, sans-serif;
				}

				.header {
					display: flex;
					justify-content: space-between;
					align-items: center;
					margin-bottom: 20px;
				}

				.menu {
					display: felx;
					gap: 10px;
					margin-bottom: 30px;
					flex-wrap: wrap;
				}

				.menu a {
					padding: 10px 15px;
					border: 1px solid #ddd;
					boreder-radius: 5px;
					text-decoration: none;
					color: #333;
					background: #fafafa;
				}

				table {
					width: 100% border-collapse: collapse;
				}

				th,
				td {
					border: 1px solid #ddd;
					padding: 10px;
					text-align: center;
				}

				th {
					background: #f2f2f2;
				}
			</style>
		</head>

		<body>

			<div class="header">
				<h2>회원 관리</h2>

				<form action="/admin/logout" method="post">
					<button type="submit">로그아웃</button>
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

			<table>
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>가입일</th>
						<th>게시글 수</th>
						<th>댓글 수</th>
						<th>좋아요 수</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td>${member.userId}</td>
							<td>${member.userName}</td>
							<td>${member.email}</td>
							<td>${member.createdAt}</td>
							<td>${member.boardCount}</td>
							<td>${member.replyCount}</td>
							<td>${member.likeCount}</td>
							<td>
								<a href="/admin/members/${member.userId}">상세</a>
							</td>
						</tr>
					</c:forEach>

					<c:if test="${empty memberList }">
						<tr>
							<td colspan="8">회원 데이터가 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>

			<form action="/admin/members" method="get">
				<input type="hidden" name="page" value="1">
				<select name="size" onchange="this.form.requestSubmit()">
					<option value="10" ${searchDTO.size==10 ? 'selected' : '' }>10개씩 보기</option>
					<option value="20" ${searchDTO.size==20 ? 'selected' : '' }>20개씩 보기</option>
					<option value="50" ${searchDTO.size==50 ? 'selected' : '' }>50개씩 보기</option>
					<option value="100" ${searchDTO.size==100 ? 'selected' : '' }>100개씩 보기</option>
				</select>
			</form>

			<nav aria-label="회원 목록 페이지 이동">
				<c:if test="${totalPages > 0}">
					<c:if test="${startPage > 1}">
						<a href="/admin/members?page=${startPage -1}&amp;size=${searchDTO.size}">이전</a>
					</c:if>
					<c:forEach var="pageNo" begin="${startPage}" end="${endPage}">
						<c:choose>
							<c:when test="${pageNo == searchDTO.page}">
								<strong>${pageNo}</strong>
							</c:when>
							<c:otherwise>
								<a href="/admin/members?page=${pageNo}&amp;size=${searchDTO.size}">${pageNo}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${endPage < totalPages}">
						<a href="/admin/members?page=${endPage + 1}&amp;size=${searchDTO.size}">다음</a>
					</c:if>
				</c:if>
			</nav>

		</body>

		</html>