package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack(); // s라는 변수안에 담아냄 Controller안에서만 쓰기 위해 private를 붙임 
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		// 데이터를 setter를 이용해 저장하고 "저장 완료되었습니다." 결과를 반환
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
//		System.out.println(s);
		return "저장 완료되었습니다."; 
	}
	
	public String confirmData() {
		// 저장된 데이터를 반환
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor()
				+ ") " + s.getNumOf() + "개 " + s.getPrice() + "원";
	}
}
