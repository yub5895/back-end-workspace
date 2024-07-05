package com.kh.example.practice1.model;

public class Member {
	private String id; 
	private String pwd; 
	private String name; 
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member() {}
	
	public void changeName(String name) { // String name을 써놨기 때문에 어플리케이션에서 값입력 가능한거.
		this.name = name; // this를 이용해 같은 클래스 안에서 불러옴
							// 얘는 값을 변경하는 기능으로 사용했기에 값을 어플리케이션에 입력해야함.
	}
	
	public void printName() { // 얘는 출력하는 기능으로 사용했기에 syso를 사용함.
		System.out.println(name); // 여기 name에서는 this생략, 위에서 생략 안한이유는 String name을 불러버릴까봐
	}
	


}
