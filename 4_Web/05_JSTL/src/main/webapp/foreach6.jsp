<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<c:forEach var="i" begin="0" end="6" step="1">
		<h${i}>JSTL..!!</h${i}>
	</c:forEach>
</body>
</html>