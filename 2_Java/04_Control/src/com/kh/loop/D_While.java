package com.kh.loop;

import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 */
	// 1~5까지 출력 : for -> while
	public void method1() {
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println();
		
		int i = 1;
		while(i<=5) { //while문은 for문과 다르게 조건식만 온다. 초기문과 반복문은 while 밖에 둔다.
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 * 무한루프 & break 문과 함께 사용
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 */
	public void method2() {
		while(true) {
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break; // 입력된 숫자가 0인경우 멈추겠다.라는 의미
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * 
	 *  - 조건과 상관없이 무조건 한 번은 실행
	 *  - 거의 쓸 일이 없음...
	 *  
	 */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		} while(number == 0);
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 입력해서 임의로 지정한(Random)값을 맞히면 게임 끝!
	 * 게임이 끝나면 몇 번만에 맞혔는지 출력!
	 * 
	 * (예 : 57)
	 * 1과 100 사이의 값 입력 > 35
	 * 더 큰 수를 입력하세요
	 * 1과 100 사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 57
	 * 3번 만에 맞혔습니다.
	 */
	public void method4() {
		// 0 <= Math.random() < 1 == 그냥 랜덤값넣으면 0만나오던 이유
		int random = (int) (Math.random() * 100 + 1); // 곱하면 0~99까지라 +1해줘야 1~100까지임
		int num = 0;
		int count = 0;
		while (true) {
			count++;
			System.out.print("1과 100 사이의 값 입력 > ");
			num = sc.nextInt();
			if (random > num) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (random < num) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println(count + "번 만에 맞혔습니다.");
				break;
			}
		}
	}
	
	/*
	 * --------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------
	 * 선택 > 1
	 * 예금액 > 5000
	 * --------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------
	 * 선택 > 2
	 * 출금액 > 2000
	 * --------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------
	 * 선택 > 3
	 * 잔고 > 3000
	 * --------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * --------------------------------
	 * 선택 > 4
	 * 프로그램 종료
	 */
	public void method5() {
		
		int balance = 0; // 잔고를 while문 바깥에다 스타트 while문 안에 넣으면 초기화됨
		boolean check = true;
		while (check) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.println("선택 > ");
			int select = sc.nextInt();

			/*
			if (select == 1) {
				System.out.println("예금액 > ");
				int money = sc.nextInt();
				balance += money; // 바깥의 balance에 money만큼 추가한다
			} else if (select == 2) {
				System.out.println("출금액 > ");
				balance -= sc.nextInt();
			} else if (select == 3) {
				System.out.println("잔고 > " + balance);
			} else if (select == 4) {
				System.out.println("프로그램 종료");
				break;
			}*/
			switch(select) {
				case 1:
					System.out.println("예금액 > ");
					int money = sc.nextInt();
					balance += money;
					break;
				case 2:
					System.out.println("출금액 > ");
					int ex = sc.nextInt();
					if (ex > balance) System.out.println("잔고가 부족합니다 ㅠㅠ");
					else balance -= ex; //  이방법으로 잔고부족을 만들 수 있음
					break;
				case 3:
					System.out.println("잔고 > " + balance);
					break;
				case 4: 
					System.out.println("프로그램 종료");
					check = false;
					break; // 이건 switch에서 나가는 방법이라 while에서 나가려면 switch밖에 break를 1개 더해주거나 boolean을 추가해줘야함
			}
		}
		
	}

	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1(); 
//		d.method2();
//		d.method3(); 
//		d.method4();
		d.method5();
	}

}
