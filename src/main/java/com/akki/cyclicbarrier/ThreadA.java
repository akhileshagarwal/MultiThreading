package com.akki.cyclicbarrier;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadA extends Thread {
	private Queue<Integer> queue;
	private volatile CyclicBarrier even;
	private volatile CyclicBarrier odd;

	public ThreadA(Queue<Integer> queue, CyclicBarrier even, CyclicBarrier odd) {
		super("Thread A");
		this.queue = queue;
		this.even = even;
		this.odd = odd;
	}

	@Override
	public void run() {
		while (!queue.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + " " + queue.poll());
			try {
				even.await();
				even.reset();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}