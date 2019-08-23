package com.chinasofti.springcloud.test;

import java.util.concurrent.CountDownLatch;

public class TestDemo {
	
	public static void main(String[] args) throws Exception {
		
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread1 running...");
				countDownLatch.countDown();
			}
		});
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread2 running...");
				countDownLatch.countDown();
			}
		});
		thread2.start();
		
		countDownLatch.await();
		System.out.println("main thread finish");
	}
	
}
