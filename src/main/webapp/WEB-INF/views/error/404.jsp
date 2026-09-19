<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html lang="ko">

		<head>
			<meta charset="UTF-8">
			<title>요청한 정보를 찾을 수 없습니다</title>
		</head>

		<body>
			<main>
				<h1>요청한 정보를 찾을 수 없습니다</h1>
				<p>
					<c:out value="${message}" />
				</p>

				<c:url var="adminHomeUrl" value="/admin" />
				<a href="${adminHomeUrl}">관리자 홈으로 돌아가기</a>
			</main>
		</body>

		</html>