package com.kh.stream.intermediate;

import java.util.Arrays;

/*
 * 반복
 * - 요소 전체를 반복하는 역할
 * - peak : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업
 */

public class D_Looping {

	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5};
		
		// 1 ~ 5 중 짝수의 합계
		// peek -> 편한이유가, 중간처리기 때문에 얼마든지 사용할 수 있음.
		int sum = Arrays.stream(values)
				.filter(num -> num % 2 == 0)
				.peek(num -> System.out.println(num))
				.sum();
		System.out.println(sum);
		
		// forEach
		Arrays.stream(values)
		.filter(num -> num % 2 == 0)
		.forEach(num -> System.out.println(num)); // sum도 최종처리, forEach도 최종처리기 때문에 같이쓸순없음, 하나씩 써야됨
		
		int sum2 = Arrays.stream(values)
				.filter(num -> num % 2 == 0)
				.sum();
		System.out.println(sum2);
	}

}
