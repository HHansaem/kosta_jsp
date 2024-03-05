<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name"); 
	String id = request.getParameter("id");
// session 사용시 나를 호출한 얘한테 name과 id 값 공유 O 
// request.setAttribute를 하면 값이 공유 X 
// foward 나 include 사용하면 값 공유 O
// sendRedirect는 값 공유 X
	session.setAttribute("name", name);
	session.setAttribute("id", id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=name %>님의 아이디는 <%=id %>입니다.</h3>
	<form action="attributeTest2.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2">추가할 데이터들</td>
			</tr>
			<tr>
				<td>e-mail 주소</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>집 주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>