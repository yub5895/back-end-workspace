package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		Member Member = new Member();
		Member.changeName("배영운");
		Member.printName();
	}

}
