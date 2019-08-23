package com.chinasofti.springcloud.util;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofti.springcloud.service.UserMessageService;

public class ThreadLocalDemo {
	
	@Resource(name="userMessageService")
	@Autowired
	private UserMessageService userMessageService;
	
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			final Thread t = new Thread(){
				@Override
				public void run() {
					System.out.println("当前线程:" +Thread.currentThread().getName() + " ,已分配ID:" +Thread.currentThread().getId());
				}
			};
			t.start();
		}
		
	}
	

}
