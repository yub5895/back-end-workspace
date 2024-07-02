package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {

	/*
	 * 변수 : 하나의 공간에 하나의 값을 담음
	 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 * 
	 * 배열의 선언
	 * 자료형[] 배열명;
	 * 자료형 배열명[];
	 * - 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라
	 * 	 배열을 다루는데 필요한 변수가 생성
	 * 
	 * 배열의 초기화
	 * 배열명 = new 자료형[배열크기];
	 * - 생성된 배열에 처음으로 값을 저장
	 * 
	 * 배열의 선언과 초기화 동시 진행
	 * 자료형[] 배열명 = new 자료형[배열크기];
	 */
	public void method1() {
		int[] nums = new int[5]; // 배열크기 지정하지 않으면 에러!
		System.out.println(nums);
		
		// 배열 생성하고 해당 값들은 초기화하지 않은 상태 -> 기본값이 들어감
		// 정수형 : 0, 실수형 : 0.0 문자형 : \u0000, 논리형 : false, 참조형 : null
		System.out.println(nums[0]); // 0번째 숫자를 출력 
		System.out.println(nums[1]); // 1번째 숫자를 출력
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		System.out.println(nums[0]);
		System.out.println(nums[1]); 
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
	}
	
	// 배열 선언과 동시에 값들 초기화
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60}; // 연달아 적어도 method1과 같은효과를 발휘함
		
		for (int i = 0; i < nums.length; i++) { 
			System.out.println(nums[i]);
		}
		for(int value : nums) {
			System.out.println(value);
		}
	}
	/*
	 * 3명의 키를 입력받아 배열에 저장하고 3명의 키의 평균값을 구하시오
	 * 키 입력 > 180
	 * 키 입력 > 177.3
	 * 키 입력 > 168.2
	 * 175.2
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		double[] arr = new double[3];
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("키 입력 > ");
			arr[i] = sc.nextDouble();
			sum += arr[i];
		}
		System.out.printf("%.1f", sum / arr.length);
//		System.out.println(Arrays.toString(arr));
	}
	
	// 배열의 복사
	// 1. 얕은 복사 : 배열의 주소만 복사
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	public void method4() {
		
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number; // 얕은복사
		
		copy[1] = 20;
				
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// 1) for 문을 이용한 깊은 복사
	public void method5() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		for(int i = 0; i < number.length; i++) {
			copy[i] = number[i];
		}
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	// 2) System 클래에서 제공하는 arraycopy() 메서드를 이용한 깊은 복사
	//	  System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		System.arraycopy(number, 0, copy, 0, number.length);
		
		copy[2] = 30; // 완전히 새걸 만든거기때문에 카피의 내용을 바꿀수있음
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	// 3) Arrays 클래스에서 제공하는 copyOf() 메서드를 이용한 깊은 복사
	// 	  Arrays.copyOf(원본배열, 복사본배열길이);
		public void method7() {
		int [] number = {1, 2, 3, 4, 5};
		int [] copy = Arrays.copyOf(number, number.length); // copyOf쓰면 바로 복사 
	}
		
	// 4) 배열의 clone() 메서드를 이용한 깊은 복사 (얘만 알아도 됨!)
		public void method8() {
			int[] number = {1, 2, 3, 4, 5};
			int[] copy = number.clone(); 
		}
		
	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method6();
		a.method7();
	}

}
