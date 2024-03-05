<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>include 되는 pageContext3.jsp 페이지입니다.</h3>
<table border="1">
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=request.getParameter("id") %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=request.getParameter("password") %></td>
	</tr>
</table>
<hr>