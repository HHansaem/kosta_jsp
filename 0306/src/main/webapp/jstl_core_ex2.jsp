<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<User> users = new ArrayList<>();
	users.add(new User("hong", "홍길동", "1234", "hong@kosta.com", "서울시 금천구"));
	users.add(new User("gong", "공길동", "1234", "gong@kosta.com", "서울시 영등포구"));
	users.add(new User("song", "송길동", "1234", "song@kosta.com", "서울시 강서구"));
// 	request.setAttribute("users", userList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1부터 10까지 1씩 증가하면서 반복  -->
	<c:forEach var="test" begin="1" end="10" step="2">
		<b>${test }</b>&nbsp;&nbsp;	
	</c:forEach>
	<br>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
<%-- 		session이나 request로 가겨온 값은 EL표기법으로 사용 가능 (items="${users }") --%>
		<c:forEach var="user" items="<%=users %>" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.email }</td>
				<td>${user.address }</td>
			</tr>
		</c:forEach>
		
<%-- 	EL표기법 사용하지 않고 작성한 코드	
	<% for(User user : users) { %>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getName() %></td>
				<td><%=user.getPassword() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getAddress() %></td>
			</tr>
		<% } %>
--%>
	</table>
	
	<c:forTokens items="홍길동#김길동#고길동#송길동" delims="#" var="name">
		<b>${name }</b>&nbsp;
	</c:forTokens>
	<br>
	<c:set var="fruitList" value="apple,banana,orange,strawberry"/>
	<c:forTokens items="${fruitList }" delims="," var="fruit">
		<b>${fruit }</b>&nbsp;
	</c:forTokens>
</body>
</html>