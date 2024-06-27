package com.kh.variable;

public class A_Variable {

	/*
	 * 변수(Variable) : 값을 저장하는 "공간"
	 **/
	
	public static void main(String[] args) {
		
		// 실행할 메서드가 있는 클래스를 생성(new)
		A_Variable variable = new A_Variable();
		
		// 생성한 클래스로 메서드 실행(호출)
//		variable.printValue();
//		variable.variableTest();
		variable.constant();
		
	}
	
	public void printValue() {
		
		// 원의 둘레와 원의 넓이를 출력하시오.
		// 원의 둘레 = 반지름 X 2 X 3.141592...
		// 원의 넓이 = 반지름 X 반지름 X 3.141592...
		
		// 변수를 사용하지 않고 
		System.out.println(30 * 2 * 3.141592);
		System.out.println(30 * 30 * 3.141592);
		
		System.out.println("-------------------");
		
		// 변수를 사용하면
		int r = 30;
		double pi = 3.141592;
		
		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi); // syso 입력 후 ctrl + 스페이스바 -> 엔터, 출력버튼은 Ctrl+F11
		
	}
	
	public void variableTest() {
		/*
		 * * 변수의 선언
		 * 
		 *   자료형 변수명;
		 *   - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보
		 *   - 변수명 : 변수의 이름으로 값을 읽고, 쓰고, 지우는 작업을 할 때 사용
		 *   
		 * * 변수의 초기화
		 *   
		 *   변수명 = 값; 
		 *   - 변수에 처음으로 값을 저장하는 것 
		 *   - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 *     
		 * */
	
		// * 기본 자료형(Primitive type) : 실제 값을 저장
		// 스택 메모리에 생성된 공간에 실제 변수값이 저장
		// 1. 논리형 : 1byte(=8bit)
		boolean isTrue; // 변수 선언
		isTrue = true;  // 변수 초기화
		
		boolean isFalse = false; // 변수 선언과 함께 초기화!
		
		// 2. 문자형 : 2byte(=16bit)
		char ch = 'a'; 
//		ch = 'ab'; 두글자 이상은 올 수 없어서 에러 발생! --> 주석 단축키 : ctrl + /
		
		// 3. 정수형
		byte bNum = 1; // 1byte(=8bit)(-128 ~ 127) 256 = 2^8
//		bNum = 128; 1byte는 127까지만 되므로 에러 발생! -> 오버플로우(Overflow)
		short sNum = 128; // 2byte(=16bit)
		int iNum = 922337283; // 4byte
		long lNum = 922337283458L; // 8byte - 숫자 뒤에 L(l)을 입력해야한다
		
		System.out.println(lNum); // 보면 L은 출력이안됨
		
		//4. 실수형
		float fNum = 1.2F; // 4byte - 숫자 뒤에 F(f)를 입력해야한다
		double dNum = 1.2; // 8byte (기본)
		
		System.out.println(fNum);
		
		// * 참조 자료형 : 4byte, 기본형을 제외한 나머지 (클래스) : 주소 값을 저장
		// 실제 데이터 값은 힙 메모리에 저장하고,
		// 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힙 메모리의 위치값을 저장
		String name = "장영태"; // 여러 글자인 경우 ''를 사용할 수 없음
		String name2 = new String("장영태"); // 정석이지만 new String을 생략함
		System.out.println(name2);
		
		// 변수의 네이밍 규칙
		// 1. 대소문자 구분한다.
		int number;
		int NUMBER;
		int Number; // 3가지 모두 다른 문자로 인식한다
//		String number; 자료형이 달라도 변수명이 같으면 에러 발생!
		
		// 2. 숫자로 시작하면 안 된다.
//		int 1age;
		int a2g3e4; // 숫자가 섞이는건 가능하다

		// 3. 특수 문자는 '_', '$'만 사용 가능하다.
		int _age;
		int age$;
//		int %age; 
//		int age@; // _와 $가 아니기 때문에 오류가 난다.
		
		// 4. 예약어(Reserved word)를 사용하면 안 된다.
//		int public;
//		int void;
//		int int; // 모두 쓰임새가 있어서 클래스명으로 사용할 수 없다. 
//		int class2; // 단 뒤에 숫자를 붙이거나 하는 방식으로 다른 이름으로 만들면 사용할 수 있다.
		
		// 5. (권장사항) 낙타표기법(카멜케이스)
		// 첫글자는 항상 소문자, 여러 단어가 오면 대문자로 구분
		int maxnumber; // 오류가 나진 않음, 하지만 카멜케이스로 사용하는건 권장사항입니다
		int max_number; // 자바에서 X, 파이썬에서 사용하는 방법 (스네이크 기법)
		int maxNumber; // 자바에서! 
	}
	
	public void constant() {
		/*
		 * 상수
		 * 
		 * final 자료형 변수명;
		 * 
		 * - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용
		 * - 초기화 이후에는 값을 변경할 수 없다. 
		 * - 상수의 네이밍 규칙은 대문자로 표기, 여러 단어가 오면 _로 구분
		 * */	
		int age = 20;
		age = 25;
		System.out.println(age);
		
		final int MAX_AGE = 30; // 상수의 네이밍 규칙은 대문자로 표기하기에, _로 단어 구분
//		AGE = 35; // final을 붙여놨기 때문에 상수가되어 에러 발생
		System.out.println(MAX_AGE);
	}
}
