package com.kh.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 스트림(stream)
 * - 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
 * 
 * * 스트림의 특징
 * - 데이터를 읽기만 할 뿐 변경하지 않는다.
 * - 일회용 (필요하면 다시 스트림 생성)
 * - 내부 반복 처리
 * - 병렬로 처리
 * 
 * * 스트림의 종류
 * - java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 갖고
 * 	 자식 인터페이스들이 상속 관계를 이루고 있다.
 * 
 * * Stream API
 * - 스트림은 자바 8부터 추가된 기능으로 컬렉션(배열)의 저장 요소들을 하나씩 참조해서
 * 	 람다식으로 처리할 수 있도록 해주는 반복자
 * - 중간 처리(intermediate), 최종 처리(terminal) 작업을 수행
 * 	  - 중간 처리 : 반복(peek), 매핑(타입 변환), 필터링, 정렬 등
 * 	  - 최종 처리 : 반복(forEach), 카운팅, 평균, 총합 등의 집계 처리
 * - 구분하는 방법은 리턴 타입으로 알 수 있음!
 * 	  - 리턴 타입이 Stream이라면 중간 처리 메서드
 *    - 리턴 타입이 기본 타입이거나, Optional 객체라면 최종 처리 메서드
 * - 지연된 연산 : 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
 */

public class Create {

	// 숫자 범위로 스트림을 생성 - IntStream, LongStream, DoubleStream
	public void method1() {
		
		// 첫 번째 매개 값 ~ 두 번째 매개 값 이전까지의 값을 요소로 가지는 스트림 객체 생성
		IntStream stream = IntStream.range(1, 10); // 1 ~ 9
		int sum = stream.sum();
		System.out.println("range의 sum : " + sum);
		
		// 첫 번째 매개 값 ~ 두 번째 매개 값까지의 값을 요소로 가지는 스트림 객체 생성
		stream = IntStream.rangeClosed(1, 10); // 1 ~ 10
		sum = stream.sum();
		System.out.println("rangeClosed의 sum : " + sum);
	}
	
	/*
	 * 배열(컬렉션)로부터 스트림을 생성하는 방법
	 */
	public void method2() {
		String[] names = {"김현호", "우현성", "김경주", "주준영", "조창현", "김진주"};
		List<String> nameList = Arrays.asList(names);
		
		System.out.println(nameList);
		
		// 스트림으로 변경
		Stream<String> stream = Arrays.stream(names);
		stream.forEach(name -> System.out.println(name));
		
		stream = nameList.stream();
		stream.forEach(name -> System.out.println(name));
		
	}
	
	public static void main(String[] args) {
		Create c = new Create();
//		c.method1();
		c.method2();
	}
	
}
