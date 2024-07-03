package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {
		
		Car c = new Car();
		
		/*
		c.color = "red";
		c.gearType = "auto";
		c.door = 4;
		private를 사용해 막아버렸기 때문에 사용 불가 */ 
		
		Car car1 = new Car("white", "auto", 4); 
		Car car2 = new Car("black", "manual");
		
		System.out.println(car1);
		System.out.println(car2);
	}
		
	
	/*
	 * 오버로딩 : 한 클래스 내에 동일한 이름의 메서드를
	 * 			매개변수의 자료형과 개수, 순서가 다르게 작성되어야 함 -> ()안의 매개변수가 같으면 사용 불가 
	 */
	void test() {}
	void test(int a) {}
	// void test(int b) {} -> 위와 매개변수 자료형, 개수, 순서가 같아서 사용 불가
	void test(int b, String s) {}
	void test(String s, int b) {} // 순서가 달라서 다른 것으로 인지
	void test(int a, int b) {} // 사용 가능
}
