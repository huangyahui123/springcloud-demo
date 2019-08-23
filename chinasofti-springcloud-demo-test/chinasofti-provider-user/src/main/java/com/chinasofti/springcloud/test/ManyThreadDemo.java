package com.chinasofti.springcloud.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManyThreadDemo {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 5000; i++) {
			ExecutorService executorService = Executors.newFixedThreadPool(100);
			
			executorService.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});;
			
			executorService.shutdown();
		}
		
	}
}
