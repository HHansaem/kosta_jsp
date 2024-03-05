<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request 예제입니다</h1>
	<table border="1" style="width: 400px;">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=request.getParameter("gender") %></td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<%
// 					getParameterValues : 해당 항목에 모든 값들을 가져옴
					String[] hobbys = request.getParameterValues("hobby");
					for(String hobby : hobbys) {
				%>
					<%= hobby %>&nbsp;&nbsp;
				<% } %>
			</td>
		</tr>
		<tr>
			<td>기술</td>
			<td>
				<%
					String[] skills = request.getParameterValues("skill");
					for(String skill : skills) {
				%>
					<%= skill %>&nbsp;&nbsp;
				<% } %>
			</td>
		</tr>
	</table>
</body>
</html>