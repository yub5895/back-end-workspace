package com.kh.controller;

import java.io.IOException;

import com.kh.model.vo.Member;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member member = new Member("id", "password", "name");
		
		HttpSession session = request.getSession();
		request.setAttribute("info", member);

		response.sendRedirect("index.jsp");
	}
}