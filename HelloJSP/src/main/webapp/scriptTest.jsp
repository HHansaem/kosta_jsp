<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!  //변수나 메서드 선언할 때 (전역적)
	int age = 20;
	String name = "hong";
	String info() {
		return String.format("name:%s, age:%d", name, age);
	}
%>
<%  //JSP 페이지가 요청될 때마다 실행 (지역적)
	int lage = 30;
	String lname = "gildong";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>