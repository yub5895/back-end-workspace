package com.kh.practice.controller;

import com.kh.practice.model.Member;

public class BookController {
	int count = 0; // 
	boolean check = true; 
	
	private Member member = new Member();
	
	// 내 정보 추가
	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	// 마이페이지
	public Member myPage() {
		return member;
	}
	public void rentBook() {
		
	}
}
