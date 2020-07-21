<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판일</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.b_num}</td>
				<td>${book.b_title}</td>
				<td><a href="/book/view?b_num=${book.b_num}">${book.b_author}</a></td>
				<td>${book.b_credate}</td>
				<td>${book.b_desc}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/views/book/book-insert"><button>도서추가</button></a>
</body>



</html>