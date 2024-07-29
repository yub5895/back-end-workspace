package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member = dao.search(id);
			
			if(member!=null) {
				// 성공하면 views/search_ok_jsp 해당 정보 출력
				// 바인딩 - request
				request.setAttribute("member", member);
				request.getRequestDispatcher("/views/search_ok.jsp").forward(request, response);
			} else {
				// 실패하면 views/search.fail.jsp "검색 실패했습니다" 출력
				response.sendRedirect("search_fail.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
