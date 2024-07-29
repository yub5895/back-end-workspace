package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한자바 클래스
 */
public class RegisterController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id"); // getParamter는 소환술
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Member member = new Member(id, password, name);
		
		dao.register(member);

		return new ModelAndView("index.jsp", true);
	}
	
}
