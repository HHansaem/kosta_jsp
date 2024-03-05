<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- pageContext3.jsp의 페이지 먼저 출력 -->
	<% pageContext.include("pageContext3.jsp"); %>
	<h2>pageContext forward 메소드로 포워딩된 페이지입니다.</h2>
	<table border="1">
		<tr>
			<td>이메일</td>
			<td><%=request.getParameter("email") %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=request.getParameter("address") %></td>
		</tr>
	</table>
</body>
</html>