<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$('#checkJson').click(function() {
			let obj = {name:['홍길동', '이순신', '임꺽정']};  //배열을 객체에 담기
			console.log(obj);
			
			let jsonArr = JSON.stringify(obj);  //자바스크립트 객체 -> JSON 문자열
			console.log(jsonArr);
			
			let nameArr = JSON.parse(jsonArr);  //JSON 문자열 -> 자바스크립트 객체
			let output = "회원이름<br>=============<br>";
			nameArr.name.forEach(function(item) {  //배열 값들 반복문을 통해 output변수에 저장
				console.log(item);
				output += item+"<br>"
			})
			$('#output').html(output);  //output변수에 저장돼있는 거 출력
		})
	})
</script>
<body>
	<a id="checkJson">출력</a><br><br>
	<div id="output"></div>

</body>
</html>