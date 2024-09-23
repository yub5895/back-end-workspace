package com.kh.test5;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.test5.model.Food;

public class Application {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		ArrayList<Food> list = new ArrayList<>();
		
		while(true) {
			System.out.println("=== 음식 메뉴 리스트");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.println("번호 선택 : ");
			int number = Integer.parseInt(sc.nextLine());
			
			if(number == 1) {
				System.out.println("추가할 음식 입력 : ");
				String name = sc.nextLine();
				System.out.println("칼로리 입력 : ");
				int kcal = Integer.parseInt(sc.nextLine());
				list.add(new Food(name, kcal));
				System.out.println("음식 정보가 추가되었습니다.");
			} else if (number == 2) {
				for(Food food : list) {
					System.out.println(food);
				}
			} else if (number == 3) {
				System.out.println("삭제하고 싶은 음식 선택 : ");
				String delete = sc.nextLine();
				
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getName().equals(delete)) {
						System.out.println(list.remove(i) + "가 삭제되었습니다.");
					}
				}
				
			} else if (number == 4) {
				break;
			}

		}

	}
}
