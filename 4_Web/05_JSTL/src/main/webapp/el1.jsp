<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("result", "request"); // 얘는 값을 여기서만 갖고있음
		session.setAttribute("result", "session"); // 세션은 분명 값을 여기서갖고있는데, 같이 이동시켜버림
//		response.sendRedirect("el1_view.jsp"); // 이 위치로 강제로 이동시켜버림. 그래서 웹키면 이 링크만 켜질거임
		request.getRequestDispatcher("el1_view.jsp").forward(request, response); // 값을 같이 이동시킴. 그래서 request는 값을 여기서만 갖고있는데도 같이 이동시킴
	%>
	
</body>
</html>