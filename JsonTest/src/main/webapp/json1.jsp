<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	let obj = {id:'1001', name:'hong', age:30};
	console.log(typeof obj);
	console.log(obj);
	
	//자바스크립트 객체 변수를 백앤드로 보내기 위해 JSON 형태의 문자열로 변환해야 함
	//자바스크립트 객체 ==> JSON 문자열 : JSON.stringify
	let objJson = JSON.stringify(obj);
	console.log(typeof objJson);
	console.log(objJson);
	
	//백앤드에서 받은 데이터(JSON 형태의 문자열)을 자바스크립트 객체 타입으로 변환
	//JSON 문자열 ==> 자바스크립트 객체 : JSON.parse
	let robj = JSON.parse(objJson);
	console.log(typeof robj);
	console.log(robj);
</script>
<body>

</body>
</html>