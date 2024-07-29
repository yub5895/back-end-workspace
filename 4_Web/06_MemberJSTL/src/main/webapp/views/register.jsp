<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/register" method="post"> <%-- 포스트방식을 써 개인정보 유출되지 않도록 함 --%>
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="password"><br>
		이름 : <input type="text" name="name">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>