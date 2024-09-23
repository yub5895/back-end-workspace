package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id")); //
		
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			Employee employee = dao.search(id);
			System.out.println(employee);
			
			if(employee!=null) {
				request.setAttribute("employee", employee); //
				request.getRequestDispatcher("views/search.jsp").forward(request, response); // 
			} else {
				response.sendRedirect("views/fail.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
