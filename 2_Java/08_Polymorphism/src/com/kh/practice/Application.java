package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	Book[] books = {new Book("밥을 지어요", true, 0),
				new Book("오늘은 아무래도 덮밥", false, 0),
				new Book("원피스 108", false, 15),
				new Book("귀멸의 칼날 23", false, 19)};
	
	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
	}

	public void menu() {
		System.out.println("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		
		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.println("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());

			if (number == 1) { // 1을 입력할 경우 member(클래스)를 소환한다
				System.out.println(member);
				
			} else if (number == 2) { // 2를 입력할 경우 book(객체 배열)를 길이만큼 소환한다
				for (int i = 0; i < books.length; i++) {
					System.out.println((i + 1) + "번 도서 : " + books[i]); // i+1은 "번 도서" 앞에 숫자를 올라가게 하기 위함
				}
				System.out.println("대여할 도서 번호 선택 : ");
				int select = Integer.parseInt(sc.nextLine());
				// select(index+1) 번호에 따라서 해당 책이 Member - bookList에 추가되어야 한다.
				member.getBookList()[0] = books[select - 1];
				// member클래스의 booklist배열 0번자리는 books[select]가 들어간다.
				// select-1이 되는 이유는, 위에서 번호를 붙이기 위해 i+1이 되었기 때문이다.
				
				if (age < 15 && select == 3) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
//					member.getBookList()[0] = books[select - 1]; -> 삭제 할 방법 필요
				} else if (age < 19 && select == 4) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				}
				
			} else {
				break;
			}
		}

	}
}
