<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="page" />
<jsp:setProperty name="user" property="name" value="hong"/>
<jsp:setProperty name="user" property="email" value="hong@kosta.com"/>
<jsp:setProperty name="user" property="address" value="seoul"/>

<!-- 이렇게 써도 됨 (똑같음) -->
<%-- <%
	bean.User user2 = new bean.User();
	user2.setName("hong");
	user2.setAge(30);
	user2.setAddress("seoul");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><jsp:getProperty property="name" name="user"/></h3>
	<h3><jsp:getProperty property="email" name="user"/></h3>
	<h3><%=user.getAddress() %></h3>
</body>
</html>