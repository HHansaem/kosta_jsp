<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
// getAttribute는 Object타입이기 때문에 String으로 다운캐스팅
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String tel = request.getParameter("tel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=name %>님 정보입니다.</h3>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=email %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=address %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=tel %></td>
		</tr>
	</table>
</body>
</html>