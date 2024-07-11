package com.kh.practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.model.Singer;
import com.kh.practice.model.Song;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Song> list = new ArrayList<Song>();

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
				String Song = sc.next(); 
				System.out.println("가수 명 : ");
				String Singer = sc.next();
				list.add(new Song(Song.get(0))); // 클래스를 송+싱어 1개만 하고 송부분에만 추가, 싱어부분에만 추가할수 있는지 생각
				list.add(new Singer(Singer));
				System.out.println("추가 성공");
				break;
			case 2:
				System.out.println("****** 첫 위치에 곡 추가 ******");
				System.out.println("곡명 : ");
				String Song2 = sc.next();
				System.out.println("가수 명 : ");
				String Singer2 = sc.next();
				list.add(0, new Song(Song2));
				list2.add(0, new Singer(Singer2));
				System.out.println("추가 성공");
				break;
			case 3:
				System.out.println("****** 전체 곡 목록 출력 ******");
				
				for (Singer ss : list2 + Song s : list) {
					System.out.print(ss.getSinger() + " - " + s.getSong());
					} // 클래스를 송/싱어 두개로 나누고 출력할때 합쳐서 하는 방법이 있는지 생각

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