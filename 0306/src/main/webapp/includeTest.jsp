<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>include 액션 테스트</h2>
	<jsp:include page="includeTest1.jsp">
		<jsp:param value="honggildong" name="name"/>
		<jsp:param value="30" name="age"/>
	</jsp:include>
</body>
</html>