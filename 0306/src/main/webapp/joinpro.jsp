<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="bean.User" scope="page" />
<!-- property값을 param에 할당 -->
<%-- 
<jsp:setProperty name="user" property="id" param="id"/> 
<jsp:setProperty name="user" property="name" param="name"/> 
<jsp:setProperty name="user" property="password" param="password"/> 
<jsp:setProperty name="user" property="email" param="email"/> 
<jsp:setProperty name="user" property="address" param="address"/>  
--%>
<!-- 위 처럼 property와 param의 이름이 같으면 다음과 같이 한 번에 작성할 수 있다 -->
<jsp:setProperty name="user" property="*"/> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><jsp:getProperty name="user" property="id" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><jsp:getProperty name="user" property="name" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><jsp:getProperty name="user" property="password" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><jsp:getProperty name="user" property="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><jsp:getProperty name="user" property="address" /></td>
		</tr>
	</table>
</body>
</html>