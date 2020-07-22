<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빌려간 사람</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>대여번호</th>
			<th>대여일자</th>
			<th>반납일자</th>
			<th>대여자</th>
			<th>대여도서</th>
		</tr>
		<c:forEach items="${lentlist}" var="lent">
			<tr>
				<td>${lent.l_num}</td>
				<td><a href="/lent/view?l_num=${lent.l_lentdate}">${lent.l_id}</a></td>
				<td>${lent.l_recdate}</td>
				<td>${lent.l_m_member}</td>
				<td>${lent.l_credate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>