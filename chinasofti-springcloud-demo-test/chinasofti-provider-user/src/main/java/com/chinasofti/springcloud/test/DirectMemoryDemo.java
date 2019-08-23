package com.chinasofti.springcloud.test;

import java.nio.ByteBuffer;
import java.util.Date;

public class DirectMemoryDemo {
	
	public static void main(String[] args) {
		int time = 1000000;
		Date begin = new Date();
		ByteBuffer buffer = ByteBuffer.allocate(2*time);
		for(int i=0;i<time;i++){
		    buffer.putChar('a');
		}
		buffer.flip();
		for(int i=0;i<time;i++){
		    buffer.getChar();
		}
		Date end = new Date();
		System.out.println(end.getTime()-begin.getTime());
		
		
		begin = new Date();
		ByteBuffer buffer2 = ByteBuffer.allocateDirect(2*time);
		for(int i=0;i<time;i++){
		    buffer2.putChar('a');
		}
		buffer2.flip();
		for(int i=0;i<time;i++){
		    buffer2.getChar();
		}
		end = new Date();
		System.out.println(end.getTime()-begin.getTime());
		
	}
	
}
