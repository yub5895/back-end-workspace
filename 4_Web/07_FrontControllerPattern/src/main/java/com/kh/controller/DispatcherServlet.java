package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;
@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Container에서 Servlet을 하나로 만들자! FrontController Pattern
	 * 
	 * 소프트웨어 디자인 패턴 중 하나로 웹 애플리케이션 등에서 사용되는 패턴 중 하나
	 * 애플리케이션의 진입점을 중앙집중화하여 요청을 처리하고, 전체적인 흐름을 제어하는 역할
	 * 
	 * - DispatcherServlet은 자바 기반의 웹 애플리케이션에서 
	 * 	FrontControllerPattern을 구현하는데 사용되는 핵심 컴포넌트
	 * - SpringFraemwork와 관련된 개념으로 많이 사용되는데
	 *  SpringMVC의 일부로 동작하며 웹 요청을 받아서 적절한 핸들러(컨트롤러)로 라우팅하고,
	 *  해당 컨트롤러의 실행 및 응답 생성 등을 관리
	 *  
	 *  코드 유지보수성을 위해서 바꿈!! 그리고 스프링 프레임워크 구조이기도 함
	 * */
	
	MemberDAO dao = new MemberDAO();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인지 값을 하나 더 받는다 - command
		String command = request.getParameter("command");
		String path = "/";
		
		try {
			if (command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("search")) {
				path = search(request, response);
			} else if(command.equals("allMember")) {
				path = allMember(request, response);
			} else if(command.equals("logout")) {
				path = logout(request, response);
			}

			request.getRequestDispatcher(path).forward(request, response);

		} catch (Exception e) {

		}

	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {;
		String id = request.getParameter("id"); // getParamter는 소환술
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Member member = new Member(id, password, name);
		
		dao.register(member);

		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = new Member();
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
			
		return "index.jsp";
	}

	protected String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		Member member = dao.search(id);
		
		if(member!=null) {
			request.setAttribute("member", member);
			return "/views/search_ok.jsp";
		} else {
			return "/views/search_fail.jsp";
		}
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws SQLException{
			List<Member> list = dao.all();
			request.setAttribute("list", list);
			return "/views/allMember.jsp";
		
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse respons) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member!=null) {
			session.invalidate();
		}
		return "index.jsp";
	}
}
