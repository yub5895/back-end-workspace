package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {
		
		BeepThread beep = new BeepThread();
		Thread thread = new Thread(beep); // runnable을 사용하는 경우 얠 같이 넣어줘야함 extends thread와 차이 확인 
		thread.start(); 
		
		// 경고음 5번 울리는 작업
		Toolkit tool = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			tool.beep();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
