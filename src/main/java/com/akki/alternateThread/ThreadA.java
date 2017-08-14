package com.akki.alternateThread;

import java.util.Queue;

public class ThreadA extends Thread {
	private Queue<Integer> queue;
	public volatile Flag flag;
	private String lock;

	public ThreadA(Queue<Integer> queue, Flag flag, String name) {
		super("Thread A");
		this.queue = queue;
		this.flag = flag;
		this.lock = name;
	}

	@Override
	public void run() {
		while (!queue.isEmpty()) {
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName() + " " + queue.poll());
				flag.setProcessedByA(true);
				lock.notify();
			}
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (!flag.isProcessedByB()) {
				try {
					synchronized (queue) {
						queue.wait();
					}
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}