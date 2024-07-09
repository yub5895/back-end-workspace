package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice3.model.Book;

public class Application {
	Book book = new Book();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainBook();
		
	}
	
	public void mainBook() {
		Scanner sc = new Scanner(System.in);
		boolean check = true;

		
			System.out.println("이름 : ");
			String name = sc.nextLine();
			System.out.println("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			while (true) {
			System.out.println("====메뉴====");
			System.out.println("1.마이페이지");
			System.out.println("2.도서 대여하기");
			System.out.println("3.프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				myPageBook();
				break;
			case 2:
				rentalBook();
				break;
			case 3:
				check = false;
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	
	public void rentalBook() {
		System.out.println("1번 도서 : " + book.toString());
		System.out.println("2번 도서 : ");
		System.out.println("3번 도서 : ");
		System.out.println("4번 도서 : ");
	}

	public void myPageBook() {
		System.out.println("마이페이지 테스트");
	}
	
}
