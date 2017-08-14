package com.akki.countdownlatch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class Main {
	String mutex = new String();

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch even=new CountDownLatch(1);
		CountDownLatch odd=new CountDownLatch(1);
		Queue<Integer> buffer = new LinkedList<>();
		for(int i=1;i<11;i++){
			buffer.add(i);
		}
		
		Thread threadA = new ThreadA(buffer, even, odd);

		Thread threadB = new ThreadB(buffer, even, odd);
		threadA.start();
		threadB.start();
		
	}
}
