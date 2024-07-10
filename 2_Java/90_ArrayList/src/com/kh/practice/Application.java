package com.kh.practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		while (true) {
			System.out.println("==== 메인메뉴 ====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7.가수 명 내림차순 정렬");
			System.out.println("8.곡 명 오름차순 정렬");
			System.out.println("9.종료");
			System.out.println("메뉴 번호 입력 : ");
			int number = sc.nextInt();
			switch (number) {
			case 1:
				System.out.println("****** 마지막 위치에 곡 추가 ******");
				System.out.println("곡명 : ");
				String song1 = sc.nextLine(); 
				System.out.println("가수 명 : ");
				String song2 = sc.nextLine();
				System.out.println("추가 성공");
				list.add(song1);
				list.add(song2);
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			}
		}
	}
}