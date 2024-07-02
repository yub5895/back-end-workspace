package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
		l.method2();
//		l.method3();
//		l.method4();
	}
		
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5d
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.println("숫자 입력(1~100) : ");
    	int num = sc.nextInt();
    	
    	for (int i = num; i >= 1; i--) {
    		System.out.println(i);
    	}
    	
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int sum = 0;
    
    	for (int i = 1; i <= 100; i+=2) {
    		for (int j = -2; j == i; i+=-2)
    		sum=i+=j;
    	System.out.println(i);}
    	
  
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3
    */
    public void method3() {
    	System.out.println("문자열 입력 : ");
    	String word = sc.nextLine();
    	
    	for(int i = 0; i <= word.length(); i++) {
    		System.out.println(i);
    	}
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	int random = (int) (Math.random() * 10);
    	for(int i = random; i <=10; i++) {
    		System.out.println(i);
    	}
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {

    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {

    }

}