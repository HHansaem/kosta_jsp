<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 포워드 된 페이지니까 포워드 해준 페이지의 request 사용 가능 -->
	<h2>포워드 된 페이지(forwardTest2.jsp)</h2>
	<table>
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=request.getParameter("age") %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=request.getParameter("address") %></td>
		</tr>
	</table>
<%-- 	<% pageContext.include(request.getParameter("includePage")); %> --%>  <!-- 이렇게 써도 됨 -->
<jsp:include page='<%=request.getParameter("includePage") %>'></jsp:include>
</body>
</html>