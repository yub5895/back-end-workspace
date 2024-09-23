<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	
	아이디 : <input type="text" id="id">
	<input type="button" value="중복체크" id="idCheck">
	<span id="idCheckView"></span>
	
	<!-- 중복체크 버튼을 눌렀을 때 post 방식으로
		/check로 id 값 넘겨서 결과값(boolean)을 받아서
		아이디가 있으면 ID 사용 불가, 없으면 ID 사용 가능
		DB는 스키마 : member, 테이블 : member
	 -->
	 
	 <script>
	 	$("#idCheck").click(() => {
	 		$.ajax({
	 			// 요청
	 			type: 'post',
	 			url: '/check',
	 			data: 'id=' + $("#id").val(),
	 			
	 			// 응답
	 			success: function(result) {
	 				alert(result);
	 			},
	 	})
	 	});
	 </script>
</body>
</html>