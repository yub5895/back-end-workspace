<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원검색</h1>
	<form action="/search"> <%-- get은 생략 가능 기본값임 --%>
		검색할 회원 아이디 : <input type="text" name="id"><br>
		<input type="submit" value="검색">
	</form>
</body>
</html>