package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("form으로 요청받음");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPwd = request.getParameter("userPwd");
		System.out.println(userPwd);
		String gender = request.getParameter("gender");
		System.out.println(gender);
		String[] menuList = request.getParameterValues("menu");
		System.out.print(menuList);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<p>당신의 아이디는 "+ userId + "</p>");
		out.println("<p>당신의 비밀번호는 "+ userPwd +"</p>");
		String genderResult = gender.equals("M") ? "남자" : "여자";
//		if(gender.equals("M")) genderResult = "남자";
		out.println("<p>당신의 성별은 "+ genderResult +"</p>");
		out.println("<ul>");
//		out.println("<li>" + menu[0] + "</li>");
//		out.println("<li>" + menu[1] + "</li>");
//		out.println("<li>" + menu[2] + "</li>");
//		out.println("<li>" + menu[3] + "</li>");
//		out.println("<li>" + menu[4] + "</li>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}
}
