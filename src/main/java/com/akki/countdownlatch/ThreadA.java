package com.akki.countdownlatch;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class ThreadA extends Thread {
	private Queue<Integer> queue;
	private volatile CountDownLatch even;
	private volatile CountDownLatch odd;

	public ThreadA(Queue<Integer> queue, CountDownLatch even, CountDownLatch odd) {
		super("Thread A");
		this.queue = queue;
		this.even = even;
		this.odd = odd;
	}

	@Override
	public void run() {
		while (!queue.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + " " + queue.poll());
			odd.countDown();
			try {
				even.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}