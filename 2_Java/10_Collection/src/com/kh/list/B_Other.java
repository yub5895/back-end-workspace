package com.kh.list;

import java.util.Stack;
import java.util.Vector;

public class B_Other {

	/*
	 * Vector
	 * - 동기화된(synchronized) 메서드로 구성 (개념은 스레드에서~)
	 * */
	public void method1() {
		Vector v = new Vector();
		v.add(0);
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		System.out.println(v);
		System.out.println("size : " + v.size()); // 3
		System.out.println("capacity : " + v.capacity()); // 10 -> 10단위로만 추가함
		
		v.trimToSize(); // 이걸이용하면 capacity를 사이즈와 같은 효과로 맞춰주긴 함. 근데 귀찮은방법
		
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());;
	}
	
	// 스택(Stack) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조
	public void method2() { // 층층이 쌓는다해서 푸쉬구조라함, 팝은 빼는 기능
		Stack s = new Stack();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop();
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println(s); // 0123넣고 3을뺐고 4를넣고 뺐고 567넣고 7을빼서 01256이 출력되는 것
	}
	// 큐(Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out) 구조
	public void method3() {
		
		// 큐는 인터페이스라 그냥은 객체연결이 안됨
		Queue q = new Linkedist(); {
	}
		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll();
		q.add(4);
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
}
	public static void main(String[] args) {
		B_Other b = new B_Other();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
