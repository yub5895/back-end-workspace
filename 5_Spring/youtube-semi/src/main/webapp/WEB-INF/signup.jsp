<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="container">
  	<h1>회원가입</h1>
  	<form action="/signup" method="post">
  <div class="mb-3">
    <label for="id" class="form-label">아이디</label>
    <input type="text" class="form-control" id="id" name="id">
    <div id="idCheck" class="form-text"></div>
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
    <div id="pwdCheck" class="form-text"></div>
  </div>
    <div class="mb-3">
    <label for="email" class="form-label">이메일</label>
    <input type="text" class="form-control" id="email" name="email">
    <div id="emailCheck" class="form-text"></div>
  </div>
    <div class="mb-3">
    <label for="phone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="phone" name="phone">
    <div id="phoneCheck" class="form-text"></div>
  </div>
  <button type="submit" class="btn btn-dark">로그인</button>
</form>
</div>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>