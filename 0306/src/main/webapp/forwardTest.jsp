<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	forward : request 공유 (forward로 넘어간 페이지에서도 request 데이터 사용 가능) -->
	<h2>포워트 액션 테스트</h2>
	<form action="forwardTest1.jsp" method="post">
<!-- 	사용자에게 보이지 않지만 폼 데이터와 함께 서버로 전송되는 데이터 -->
		<input type="hidden" name="forwardPage" value="forwardTest2.jsp">
		<input type="hidden" name="includePage" value="includeTest2.jsp">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td>기타등등</td>
				<td><input type="text" name="etc"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>