package com.akki.countdownlatch;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class ThreadB extends Thread {
	private Queue<Integer> queue;
	private volatile CountDownLatch even;
	private volatile CountDownLatch odd;
	

	public ThreadB(Queue<Integer> queue, CountDownLatch even, CountDownLatch odd) {
		super("Thread B");
		this.queue = queue;
		this.even = even;
		this.odd = odd;
	}

	@Override
	public void run() {	
			while (!queue.isEmpty()) {
				try {
					odd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" "+queue.poll());
				even.countDown();
			}
		}
	}
