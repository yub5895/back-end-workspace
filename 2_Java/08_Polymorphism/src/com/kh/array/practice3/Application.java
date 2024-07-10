package com.kh.array.practice3;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.rentalBook;
import com.kh.array.practice3.controller.BookController;

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
				my();
				break;
			case 2:
				rentalBooks();
				break;
			case 3:
				check = false;
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	
	public void rentalBooks() {
		Scanner sc = new Scanner(System.in);
		{
			ArrayList<rentalBook> list = new ArrayList<rentalBook>();
			list.add(new rentalBook("밥을 지어요", true, 0));
			list.add(new rentalBook("오늘은 아무래도 덮밥", false, 0));
			list.add(new rentalBook("원피스 108", false, 15));
			list.add(new rentalBook("귀멸의 칼날 23", false, 19));
		
		System.out.println("1번 도서 : " + list.get(0));
		System.out.println("2번 도서 : " + list.get(1));
		System.out.println("3번 도서 : " + list.get(2));
		System.out.println("4번 도서 : " + list.get(3));
		System.out.println("대여할 도서 번호 선택 : ");
		int number = sc.nextInt();
		switch (number) {
		case 1:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 3:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 4:
			System.out.println("성공적으로 대여되었습니다.");
		}
		}
	}

	
	public void my() {
		System.out.println();
	}
	
}
