package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.model.vo.Member;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("info");
		
		boolean check = false;
		
		if(check) {
			request.setAttribute("id", id);
			
			response.sendRedirect("index.jsp");
			
			request.getRequestDispatcher("search_ok.jsp").forward(request, response);
		} else {
			response.sendRedirect("search_fail.jsp");
		}
	}
}
