<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
    .header {
        text-align: center;
    }
    .container {
        margin: 0 auto;
        border: 1px solid;
        width: 280px;
        padding: 10px;
    }
    .row {
        height: 30px;
    }
    .title {
        float: left;
        width: 80px;
        font-weight: bold;
        text-align: center;
    }
    .input {
        float: left;
    }
   #submit {
        font-weight: bold;
        width: 120px;
        background-color: lightgray;
        display: block;
        margin: 0 auto;
    }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$("#submit").click(function() {
			deposit = {};
			deposit.id = $("#id").val();
			deposit.money = $("#money").val();
			console.log(deposit);
			
			$.ajax({
				url:"deposit",
				type:"post",
				async:true,
				data:{deposit:JSON.stringify(deposit)},
				success:function(result) {
					alert(result);
					$("#id").val("");
					$("#money").val("");
				},
				error:function(err) {
					alert("입금에 실패했습니다")
				}
			})
		})
	})
</script>
</head> 
<body>
<%@ include file="header.jsp" %>
	<div class="header"><h3>입 금</h3></div>
	<div class="container">
	    <div class="row">
	        <div class="title">계좌번호</div>
	        <div class="input"><input type="text" name="id" id="id"></div>
	    </div>
	    <div class="row">
	        <div class="title">입금액</div>
	        <div class="input"><input type="text" name="money" id="money"></div>
	    </div>
	    <div class="button">
	        <button id="submit">입금</button>
	    </div>
	</div>
</body>
</html>