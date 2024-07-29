package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = new Member();
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
			
		return new ModelAndView("index.jsp", true);
	}

	
}
