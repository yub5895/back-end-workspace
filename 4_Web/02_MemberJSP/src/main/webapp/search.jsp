<%@ page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"+
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member member = (Member) request.getAttribute("info"); 
	if(member!=null) {
	%>
	<h1>회원 정보 결과</h1>
	<ul>
		<li>아이디 : <%=member.getId() %></li>
		<li>비밀번호 : <%=member.getPassword() %></li>
		<li>이름 : <%=member.getName() %></li>
	</ul>
	<% } else { %>
	<h1>회원 정보가 없습니다</h1>
	<% } %>
</body>
</html>