<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>회원 상세</title>
		</head>

		<body>
			<h1>회원 상세</h1>
			<p>회원 ID:
				<c:out value="${member.userId}" />
			</p>
			<p>이름:
				<c:out value="${member.userName}" />
			</p>
			<p>이메일:
				<c:out value="${member.email}" />
			</p>
			<p>가입일:
				<c:out value="${member.createdAt}" />
			</p>
			<p>작성한 게시글 수:
				<c:out value="${member.boardCount}" />
			</p>
			<p>작성한 댓글 수:
				<c:out value="${member.replyCount}" />
			</p>
			<p>누른 좋아요 수:
				<c:out value="${member.likeCount}" />
			</p>
			<h2>최근 게시글</h2>

			<c:choose>
				<c:when test="${empty recentBoards}">
					<p>작성한 게시글이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<table>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성일</th>
								<th scope="col">좋아요 수</th>
								<th scope="col">댓글 수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentBoards}" var="board">
								<tr>
									<td>
										<c:out value="${board.idx}" />
									</td>
									<td>
										<c:out value="${board.title}" />
									</td>
									<td>
										<c:out value="${board.createdAt}" />
									</td>
									<td>
										<c:out value="${board.likeCount}" />
									</td>
									<td>
										<c:out value="${board.replyCount}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
			<h2>최근 댓글</h2>

			<c:choose>
				<c:when test="${empty recentReplies}">
					<p>작성한 댓글이 없습니다.</p>
				</c:when>
				<c:otherwise>
					<table>
						<thead>
							<tr>
								<th scope="col">댓글 번호</th>
								<th scope="col">게시글 제목</th>
								<th scope="col">댓글 내용</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recentReplies}" var="reply">
								<tr>
									<td>
										<c:out value="${reply.replyIdx}" />
									</td>
									<td>
										<c:out value="${reply.boardTitle}" />
									</td>
									<td>
										<c:out value="${reply.content}" />
									</td>
									<td>
										<c:out value="${reply.createdAt}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>

		</body>

		</html>