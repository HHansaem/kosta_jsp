<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Test</title>
</head>
<body>
	<h1>Request 예제입니다</h1>
	<form action="requestTest.jsp" method="post">
		<table border="1" style="width: 400px;">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남<input type="radio" name="gender" value="남자">
					여<input type="radio" name="gender" value="여자">
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					독서<input type="checkbox" name="hobby" value="독서">
					게임<input type="checkbox" name="hobby" value="게임">
					TV시청<input type="checkbox" name="hobby" value="TV시청">
					축구<input type="checkbox" name="hobby" value="축구">
					기타<input type="checkbox" name="hobby" value="기타">
				</td>
			</tr>
			<tr>
				<td>기술</td>
				<td>
					<select name="skill" multiple="multiple">
						<option value="프로그래밍">프로그래밍</option>
						<option value="데이터베이스">데이터베이스</option>
						<option value="운영체제">운영체제</option>
						<option value="네트워크">네트워크</option>
						<option value="컴퓨터구조">컴퓨터구조</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>