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
	<c:set var="test" value="Hello JSTL!"/>
	<c:out value="${test }"/>  <!-- EL표기법로 출력하기 -->
	<br/>
	
	<c:remove var="test"/>
	<c:out value="${test }"/> <!-- 지웠으니까 출력 안됨 -->
	
	<br/>
	<c:catch var="err">
		<%=10/0 %>
	</c:catch>
	
	<c:out value="${err }"/>
	
	<c:if test="${5<10 }">  <!-- 조건식이 true일 때만 실행 -->
		<h3>5는 10보다 작다</h3>
	</c:if>
<!-- 	c:else가 없고 if와 else if, else를 사용하려면 choose를 사용한다 -->
	<c:choose>
		<c:when test="${5+10==50 }">  <!-- if 역할 -->
			<h3>5+10은 50이다</h3>
		</c:when>
		<c:otherwise>  <!-- else 역할 -->
			<h3>5+10은 50이 아니다</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>