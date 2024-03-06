<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .header {
        text-align: center;
    } 
    .container {
        width: 280px;
        border: 1px solid black;
        padding: 10px;
        margin: 0 auto;
    }
    .row {
        height: 30px;
    }
    .title {
        float: left;
        width: 70px;
        text-align: center;
        font-weight: bold;
    }
    .input {
        float: left;
    }
    input[type='submit'] {
        font-weight: bold;
        width: 120px;
        background-color: lightgray;
        display: block;
        margin: 0 auto;
    }
</style>
</head>
<body>
	<form action="joinpro.jsp" method="post">	
		<div class="header"><h3>회원가입</h3></div>
		<div class="container">
			<div class="row">
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id"/></div>
			</div>
			<div class="row">
				<div class="title">이름</div>
				<div class="input"><input type="text" name="name"/></div>
			</div>
			<div class="row">
				<div class="title">비밀번호</div>
				<div class="input"><input type="password" name="password"/></div>
			</div>
			<div class="row">
				<div class="title">이메일</div>
				<div class="input"><input type="text" name="email"/></div>
			</div>
			<div class="row">
				<div class="title">주소</div>
				<div class="input"><input type="text" name="address"/></div>
			</div>
			<div class="button">
				<input type="submit" value="회원가입">
			</div>
		</div>
	</form>
</body>
</html>