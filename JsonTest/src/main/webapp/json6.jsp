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
			$.ajax({
				url:'json6',
				type:'post',
				async:true,
				success:function(result) {
					let pers = JSON.parse(result);
					pers.forEach(function(item) {
						let tr = `<tr><td>\${item.name}</td><td>\${item.age}</td></tr>`
						$('#pers').append(tr);
					})
				}
			})
		})
	})
</script>
</head>
<body>
	<button id="btn">요청</button><br>
	<table border="1" id="pers">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
	</table>
</body>
</html>