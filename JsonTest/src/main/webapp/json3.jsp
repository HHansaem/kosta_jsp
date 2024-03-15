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
		let interestArr = [];
		$('#btn').click(function() {
			$('input[name=interest]:checked').each(function() {
				interestArr.push($(this).val());
			})
			
			let data = {interest:interestArr};
			console.log(data);
			$.ajax({
				url:'json3',
				type:'post',
				async:true,
				data:{interest:JSON.stringify(data)},
				success:function(result) {
					alert(JSON.parse(result).res);
				}
			})
		})
	})
</script>
</head>
<body>
	<input type="checkbox" name="interest" value="프로그래밍">프로그래밍
	<input type="checkbox" name="interest" value="네트워크">네트워크
	<input type="checkbox" name="interest" value="데이터베이스">데이터베이스
	<input type="checkbox" name="interest" value="컴퓨터구조">컴퓨터구조
	<input type="checkbox" name="interest" value="자료구조">자료구조
	<button id="btn">전송</button>
</body>
</html>