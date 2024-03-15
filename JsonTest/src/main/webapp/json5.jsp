<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			let pers = {persons:[{name:"박지성",age:40},{name:"손흥민",age:30},{name:"김민재",age:32}]};
			
			$.ajax({
				url:'json5',
				type:'post',
				async:true,
				data:{param:JSON.stringify(pers)},
				success:function(result) {
					
				}
			})
		})
	})
</script>
</head>
<body>
	<button id="btn">전송</button>
</body>
</html>