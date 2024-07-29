package com.kh.controller;

import com.kh.controller.component.LoginController;
import com.kh.controller.component.RegisterController;
import com.kh.controller.component.SearchController;
import com.kh.controller.component.allMemberController;
import com.kh.controller.component.logoutController;

/*
 * Controller들을 만들어내는 공장
 * Dispatcher에서 보내주는 command 값에 따라서 생성하는 controller가 달라진다.
 * 여러개의 Controller들을 만들어내지만 공장에 해당하는 HandlerMapping은 단 하나면 충분하기 때문에 싱글톤 패턴으로 작성
 */
public class HandlerMapping {

	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if(command.equals("login.do")) {
			controller = new LoginController();
		} else if(command.equals("search.do")) {
			controller = new SearchController();
		} else if(command.equals("allMember.do")) {
			controller = new allMemberController(); 
		}  else if(command.equals("logout.do")) {
			controller = new logoutController();
		}
		
		return controller;
	}
 }
