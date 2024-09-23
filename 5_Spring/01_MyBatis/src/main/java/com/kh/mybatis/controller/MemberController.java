package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		return "index"; // 1.index.jsp를 찾아감
	}
	
	@GetMapping("/register") // 3. register.jsp를 찾아감
	public String register() {
		return "mypage/register";
	}
	
	@PostMapping("/register") // 5. member를 찾아감
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/"; // redirect는 다시 요청을하는거임 -> 멤버에 보낸 정보를 다시 받아서 리턴을 하겠다 이런 뜻
	}
	
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
	
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if(member!=null) session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		
		if(vo.getId()==null) vo.setId(member.getId());
		System.out.println(vo);
		service.update(vo);
		
		if(vo.getName()==null) vo.setName(member.getName());
		session.setAttribute("vo", vo);

		return "redirect:/";
	}
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		model.addAttribute("search", service.search(dto));
		return "index";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name="idList", required=false) List<String> idList) {
		if(idList!=null) service.delete(idList);
		return "redirect:/";
	}
	
	
}
