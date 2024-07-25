<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 만약 1이 들어온다면 "1값이 들어왔습니다" 출력
		 그 외에는 "1값이 들어오지 않았습니다" 출력
	 -->
	 <c:if test="${param.number == '1'}"> <!-- if(조건) {}하고 같음, 쌍따옴표 두번쓸 수 없어서 자바스크립트 방법인 ''를 씀 -->
	 	<h2>1값이 들어왔습니다</h2>
	 </c:if>
	 	<c:if test="${param.number != '1'}">
	 	<h2>1값이 들어오지 않았습니다</h2>
	 	</c:if>
	
	${param.number}
	
	<p></p>
</body>
</html>