<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보입력</title>
</head>
<body>
	<form method="post" action="/book/insert">
		<table border="1">
		
			<tr>
				<th>제목</th>
				<td><input type="text" name="b_title"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="b_author"></td>
			</tr>
			<tr>
				<th>비고</th>
				<td><input type="text" name="b_desc"></td>
			</tr>
			<th colspan="2"><button>책정보입력</button></th>
		</table>
	</form>
</body>
</html>