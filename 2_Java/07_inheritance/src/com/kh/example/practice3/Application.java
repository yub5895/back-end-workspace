package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emplyoee = new Employee();
		EmployeeController EmployeeController = new EmployeeController();
		
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호를 누르세요");
		int menu = sc.nextInt();
	
			if(menu == 1) {
				System.out.println("사원의 어떤 정보를 추가하시겠습니까?");
			} else if (menu == 2) {
				System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			} else if (menu == 3) {
				System.out.println("사원의 어떤 정보를 출력하시겠습니까?");
			} else {System.out.println("프로그램을 종료합니다");}
		}
	
		
		public void insertEmp() {
			System.out.println();
		}
		public void updateEmp() {
			
		}
		public void printEmp() {
			
		}
}
