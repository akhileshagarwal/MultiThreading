package com.akki.alternateThread;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	String mutex = new String();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");
		Queue<Integer> buffer = new LinkedList<>();
		Flag flag=new Flag();
		for(int i=1;i<11;i++){
			buffer.add(i);
		}
		String mutex="lock";
		Thread threadA = new ThreadA(buffer, flag, mutex);
		//isProcessedByA="true";
		//Thread.currentThread().sleep(100);
		Thread threadB = new ThreadB(buffer, flag, mutex);
		threadA.start();
		threadB.start();
		
	}
}
