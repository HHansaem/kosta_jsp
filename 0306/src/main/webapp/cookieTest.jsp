<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String value = "";
	String cookieHeader = request.getHeader("Cookie");
	
	if(cookieHeader != null) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("myproduct")) {
				name = cookie.getName();
				value = cookie.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 이름 = <%=name %></h3>
	<h3>쿠키 값 = <%=value %></h3>
</body>
</html>