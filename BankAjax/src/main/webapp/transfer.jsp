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
        width: 310px;
        padding: 10px;
    }
    .row {
        height: 30px;
    }
    .title {
        float: left;
        width: 120px;
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
			var transfer = {};
			transfer.sid = $("#sid").val();
			transfer.rid = $("#rid").val();
			transfer.money = +$("#money").val();
			
			$.ajax({
				url:'transfer',
				type:'post',
				async:true,
				data:{transfer:JSON.stringify(transfer)},
				success:function(result) {
					alert(result);
					$("#sid").val("");
					$("#rid").val("");
					$("#money").val("");
				},
				error:function(err) {
					alert("계좌이체에 실패했습니다");
				}
			})
		})
	})
</script>
</head>
<body> 
<%@ include file="header.jsp" %>
    <div class="header"><h3>계좌송금</h3></div>
    <div class="container">
        <div class="row">
            <div class="title">보내는계좌번호</div>
            <div class="input"><input type="text" name="sid" id="sid"></div>
        </div>
        <div class="row">
            <div class="title">받는계좌번호</div>
            <div class="input"><input type="text" name="rid" id="rid"></div>
        </div>
        <div class="row">
            <div class="title">송금액</div>
            <div class="input"><input type="text" name="money" id="money"></div>
        </div>
        <div class="button">
            <button id="submit">송금</button>
        </div>
    </div>
</body>
</html>