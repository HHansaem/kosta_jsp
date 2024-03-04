<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id"); 
	String name = request.getParameter("name"); 
	String password = request.getParameter("password"); 
	String email = request.getParameter("email"); 
	String address = request.getParameter("address"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=id %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=password %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=email %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=address %></td>
		</tr>
	</table>
</body>
</html>