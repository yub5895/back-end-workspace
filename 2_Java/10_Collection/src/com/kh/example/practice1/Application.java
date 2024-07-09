package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import com.kh.example.practice1.model.Lotto;

public class Application {

	public void method1() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Lotto> list = new ArrayList();
		Random r = new Random();


		list.add(new Lotto(1, 2, 3, 4, 5, 6));
		list.add(new Lotto(45, 44, 43, 42, 41, 40));
		


		
		while(true) {

			for (int i = 0; i <= list.size(); i++) {
				Collections.shuffle(list);
			System.out.println("로또번호 : " + list);}
		}
	}
	
	
	public static void main(String[] args) {
		Application a = new Application(); 
		a.method1(); 
	}
}
