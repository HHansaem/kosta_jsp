<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>config 테스트</h2>
	<table border="1">
		<tr>
			<td>초기 파라미터 이름</td>
			<td>초기 파라미터 값</td>
		</tr>
<!-- 		web.xml 파일에서 configTest1.jsp의 init-param 지정해줬음 -->
		<%
			Enumeration e = config.getInitParameterNames();
			while(e.hasMoreElements()) {
				String initParamName = (String)e.nextElement();
		%>
		<tr>
			<td><%=initParamName %></td>
			<td><%=config.getInitParameter(initParamName) %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>