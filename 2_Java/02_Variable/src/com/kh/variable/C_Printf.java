package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {

		// System.out.print(출력하고자하는값); -- 출력만 함 (줄바꿈 발생X)
		// System.out.println(출력하고자하는값); -- 출력 후 줄바꿈 발생 O
		System.out.print("hello\n"); // 값에 \n을 넣음으로써 println과 같은 효과를 낼 수 있음
		System.out.println("hello"); // print에 붙어있는 ln은 줄바꿈을 의미함
		
		System.out.println("----------------");
		
		// System.out.printf("출력하고자하는형식(포맷), 출력하고자하는값, 값, ...");
		// 출력하고자하는 값들이 제시한 형식에 맞춰서 출력만 진행
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%를 만들어보시오
		System.out.print(iNum1 + "% "); // ,는 절대 사용 불가하며 띄어쓰기는 문자로 인식하기때문에 사용가능
		System.out.print(iNum2 + "%\n");
		
		System.out.println(iNum1 + "% " + iNum2 + "%"); // 한줄로 예쁘게하고싶으면 이렇게

		
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 */
		
		System.out.printf("%d%% %d%%", iNum1, iNum2); // d 2개넣었으면 뒤에 정수도 2개 넣어줘야함,
		                                              // %를 붙이기위해선 %%로 기재해야함, 줄바꿈기능X
		System.out.println(); //-> 줄바꿈기능으로 넣었음  			  
		System.out.println("---------------");
		
		System.out.printf("%5d\n", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); // 5칸 공간 확보 후 음수 왼쪽 정렬
		
		System.out.println("---------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n", dNum1, dNum2); // 무조건 소수점 아래 6자리까지 나타냄, 그 아래는 반올림됨
		System.out.printf("%.3f\t%.2f\n", dNum1, dNum2); // 3은셋째자리까지, 2은 둘째자리까지 나타낸다는 의미
		
		System.out.println("-------------------");
		
		char ch = 'a';
		String str = "Hello";
		
		// a 		Hello a
		System.out.printf("%c %10s %c\n", ch, str, ch); // 문자와 문자열을 구분했어야 하는 문제
												       // 모두 문자열인 s로 통일해도 되긴함
													   // 앞에 숫자 대신 \t(탭)를 넣어서 띄어도됨
		System.out.printf("%C %S", ch, str); // 대문자로 C,S기입 시 대문자로 출력
		
	}

}
