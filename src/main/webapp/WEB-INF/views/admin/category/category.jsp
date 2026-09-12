<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>게시판 관리</title>
		</head>

		<body>
			<div class="header">
				<h2>게시판 관리</h2>
			</div>
			<form action="/admin/categories/new" method="get">
				<button type="submit">게시판 생성</button>
			</form>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>게시판명</th>
						<th>설명</th>
						<th>정렬 순서</th>
						<th>상태</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="boardGroup" items="${boardGroupList}">
						<tr>
							<td>${boardGroup.boardGroupIdx}</td>
							<td>${boardGroup.boardGroupName}</td>
							<td>${boardGroup.description}</td>
							<td>${boardGroup.sortOrder}</td>
							<td>${boardGroup.active}</td>
							<td><a href="/admin/categories/${boardGroup.boardGroupIdx}/edit">수정</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</body>

		</html>