package com.kh.controller.component;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchController implements Controller {

	@Override
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		Member member = dao.search(id);
		
		if(member!=null) {
			request.setAttribute("member", member);
			return new ModelAndView("/views/search_ok.jsp");
		} else {
			return new ModelAndView("/views/search_fail.jsp");
		}
	}
}
