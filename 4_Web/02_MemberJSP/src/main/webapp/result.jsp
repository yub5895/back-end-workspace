<%--
	JSP Element
	1) 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
	2) 스클릿틀릿 % % : 자바코드는 이 안에 지정
	3) 출력문 %= % : 출력하는 내용 지정
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석 : 화면에 보이지 않음 --%>
	<!--  HTML 주석 : 화면에 보임 -->
	<% Boolean check =(Boolean) request.getAttribute("check"); 
		System.out.println(check);
		if(check) { %>
			<%--// 회원가입 성공했을 때 <!-- 회원가입 성공 --%>
			<h1>회원가입 완료되었습니다..!</h1>
			<% String name = (String) request.getAttribute("name"); %>
			<h2><%=name %>님, 환영합니다!</h2>
	<%	} else { %>
			<%-- 회원가입 실패했을 때 --%> 
			<h1>회원가입 실패 ㅠㅠ</h1>
	<%	} %> <%-- <% %>로 자바코드 부분을 한줄한줄 구분해줘야하며, html코드는 <% %>밖에 있도록 해야한다 --%>
 	

</body>
</html>