package com.akki.cyclicbarrier;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadB extends Thread {
	private Queue<Integer> queue;
	private volatile CyclicBarrier even;
	private volatile CyclicBarrier odd;
	

	public ThreadB(Queue<Integer> queue, CyclicBarrier even, CyclicBarrier odd) {
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
					odd.reset();
				}catch (BrokenBarrierException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" "+queue.poll());
			}
		}
	}
