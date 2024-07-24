package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // getParamter는 소환술
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, password, name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		request.setAttribute("id", id);
//		request.getRequestDispatcher("index.jsp").forward(request, response); 아래꺼랑 차이 질문하기
		
		response.sendRedirect("/index.jsp");
	}
}
