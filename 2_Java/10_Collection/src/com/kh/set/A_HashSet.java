package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.model.Person;

/*
 * Set의 특징
 * - 중복 없음
 * - 순서 없음 
 */

// HastSet :  Set인터페이스를 구현한 대표적인 컬렉션 클래스 
public class A_HashSet {

	public void method1() {
		Set<String> set = new HashSet<>();
		
		set.add("이제훈");
		set.add("구교환");
		set.add("홍사빈");
		set.add("이제훈"); // 똑같은거 여러번 적어봤자 안나옴
		set.add("이제훈");
	
		System.out.println(set); // 순서가 없어서 get이런거 불가
		System.out.println(set.size()); // 중복된거 안세서 3 출력
		System.out.println("구교환이 포함되어 있는가? " + set.contains("구교환")); // 포함되어있는지 찾는 기능
		
		set.remove("홍사빈"); // 지우는거 가능
		System.out.println(set); 
		
		set.clear(); // 싹다삭제 가능
		System.out.println("비어있는지? " + set.isEmpty()); // isEmpty 가능(비어있는지 여부확인)
	}
		public void method2() {
			HashSet<Person> set = new HashSet<>();
			
			set.add(new Person("이제훈", 40));
			set.add(new Person("구교환", 41));
			set.add(new Person("홍사빈", 27));
			set.add(new Person("구교환", 41));
			set.add(new Person("구교환", 41));
			
			// 객체의 주소값을 가지고 비교하기 때문에 모두 다른 객체리 인식해서 중복 제거 X
			// --> 객체에 hashCode, equals 메서드 재정의 자동 생성
			System.out.println(set);
			
			for(Person p : set) {
				System.out.println(p);
			} // Person에 해쉬코드, 이퀄스 기입시 중복되는거 모두 삭제됨
			
			/*
			 * Iterator
			 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
			 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
			 */
			Iterator<Person> it = set.iterator();
			while(it.hasNext()) { // 여기있는 next는 읽어올 요소가 있는지 확인
				System.out.println(it.next()); // 여기있는 next는 다음 요소를 읽어옴A_HashSet.javaA_HashSet.java
			}
		}
	 
	public static void main(String[] args) {
		A_HashSet a = new A_HashSet();
//		a.method1();
		a.method2();
	}
}
