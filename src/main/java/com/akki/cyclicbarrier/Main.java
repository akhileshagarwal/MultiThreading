package com.akki.cyclicbarrier;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;

public class Main {
	String mutex = new String();

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier even=new CyclicBarrier(1);
		CyclicBarrier odd=new CyclicBarrier(1);
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
