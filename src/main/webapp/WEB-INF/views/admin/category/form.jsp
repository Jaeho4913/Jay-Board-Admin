<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>게시판 생성</title>
		</head>

		<body>
			<div class="header">
				<h2>게시판 생성</h2>
			</div>
			<form id="boardGroupForm" action="/admin/categories" method="post">

					<input type="hidden" name="boardGroupIdx" value="<c:out value='${boardGroup.boardGroupIdx}' />">
					
				<label>
					게시판명:
					<input type="text" name="boardGroupName" value="<c:out value='${boardGroup.boardGroupName}' />"
						maxlength="50" required>
				</label>
				<label>
					설명:
					<textarea name="description"
						maxlength="255"><c:out value='${boardGroup.description}' /></textarea>
				</label>
				<label>
					정렬 순서:
					<input type="number" name="sortOrder" value="<c:out value='${boardGroup.sortOrder}' />" min="0"
						required>
				</label>
				<label>
					상태:
					<select name="active">
						<option value="true" ${boardGroup.active ? 'selected' : '' }>활성</option>
						<option value="false" ${boardGroup.active==false ? 'selected' : '' }>비활성</option>
					</select>
				</label>

				<button type="submit">등록</button>
				<a href="/admin/categories">취소</a>
			</form>
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script src="/js/admin/category-form.js"></script>
		</body>

		</html>