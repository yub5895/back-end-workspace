package com.kh.controller.component;

import java.util.List;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class allMemberController implements Controller{

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.all();
		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp");
		
	}

}
