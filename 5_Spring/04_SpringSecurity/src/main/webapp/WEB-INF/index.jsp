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
	<a href="/register">회원가입</a>
	<a href="/login">로그인</a>
	<a href="/member" id="member">멤버 페이지</a>
	<button id="logout">로그아웃</button>
	<button id="admin">관리자 페이지</button>
	
	<script>
		$("#admin").click(() => {
			$.ajax({
				url: '/admin',
				type: 'get',
				beforeSend: function(xhr) {
					xhr.setRequestHeader('Authorization', 'Bearer ' + token);
				},
				success: function(data) {
					$('body').html(data);
				},
				error: function() {
					alert('관리자만 접근 가능합니다!');
					location.href= "/login";
				}
			})
		});
		$("#logout").click(() => {
			localStorage.removeItem("token");
		})
	
		// 로컬 스토리지에 담긴 토큰 가져오기
		const token = localStorage.getItem("token");
		$("#member").click((e) => {
			e.preventDefault();
			$.ajax({
				url: '/member',
				type: 'get',
				beforeSend: function(xhr) {
					xhr.setRequestHeader('Authorization', 'Bearer ' + token);
				},
				success: function(data) {
					console.log(data);
					$('body').html(data);
				},
				error: function() {
					alert("로그인 후 접근가능합니다")
					location.href = "/login";
				}
			})
		})
	</script>
</body>
</html>