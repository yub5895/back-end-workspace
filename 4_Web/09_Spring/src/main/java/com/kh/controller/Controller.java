package com.kh.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
