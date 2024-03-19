<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${userInfo ne Empty }">
		<b>${userInfo.nickname }</b>&nbsp;&nbsp;&nbsp;
		<c:if test="${userInfo.thumbnailImg ne Empty }">
			<img src="${userInfo.thumbnailImg }" width="50px" height="50px">
		</c:if><br>
		<img src="${userInfo.profileImg }" width="50px" height="50px">
		<a href="logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=64a71bf8086477eb48501855a911415f
				&redirect_uri=http://localhost:8080/social/kakao&response_type=code">
			<img src='<c:url value="/image/kakao_login_medium_narrow.png"/>' /> 
		</a>
		<br>
		<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=9WuvA_UwnYXoFM0MJimD
				&redirect_uri=http://localhost:8080/social/naver&state=9817">
			<img src='<c:url value="/image/naver_login.png"/>' height="50px" /> 
		</a>
	</c:otherwise>
</c:choose>
</body>
</html>