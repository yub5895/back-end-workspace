package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {

	public static void main(String[] args) {

		/*
		 * 비교 연산자 a < b : a가 b보다 작은가? a > b : a가 b보다 큰가? a <= b : a가 b보다 작거나 같은가? a >= b
		 * : a가 b보다 크거나 같은가? a == b : a와 b가 같은가? a != b : a와 b가 같지 않은가?
		 * 
		 * - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false *
		 */

		D_Comparison d = new D_Comparison();
		d.method1();
		d.method2();
	}

	public void method1() {
		int a = 10;
		int b = 25;

		System.out.println(a == b); // false
		System.out.println(a <= b); // true
		
		boolean result = a > b;
		System.err.println(result); // false
		
		System.out.println((a * 2) > (b / 5)); // true
		
		// 짝수와 홀수
		// 2로 나눴을 때 나머지가 0인 경우 == 2로 나누어 떨어진다는 의미 == 짝수
		//			  나머지가 1인 경우 == 2로 나누어 떨어지지 않음 == 홀수
		System.out.println("a가 짝수인가? : " + (a % 2 == 0)); // true
		System.out.println("b가 홀수인가? : " + (b % 2 != 0)); // true
		System.out.println("b가 홀수인가? : " + !(b % 2 == 0)); // 느낌표위치 맨앞에 붙여도됨 
		System.out.println("b가 홀수인가? : " + (b % 2 == 1)); 
	}
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 입력 > ");
		int num1 = sc.nextInt();
		
		System.out.println("두번쨰 정수 입력 > ");
		int num2 = sc.nextInt();
		
		// 첫번째 수가 두번째 수보다 큽니까?
		System.out.println(num1 > num2);

		// 첫번째 수가 짝수입니까?
		System.out.println(num1 % 2 == 0);
		
		System.out.println(num2 > 'A'); // A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
	}
}
