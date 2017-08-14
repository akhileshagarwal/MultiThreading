package com.akki.alternateThread;

import java.util.Queue;

public class ThreadB extends Thread {
	private Queue<Integer> queue;
	private volatile Flag flag;
	private String lock;

	public ThreadB(Queue<Integer> queue, Flag flag, String lock) {
		super("Thread B");
		this.queue = queue;
		this.flag = flag;
		this.lock = lock;
	}

	@Override
	public void run() {	
			while (!queue.isEmpty()) {
				synchronized (lock) {
				while (!flag.isProcessedByA()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				synchronized (queue) {
				System.out.println(Thread.currentThread().getName()+" "+queue.poll());
				flag.setProcessedByB(true);
				queue.notify();
				}
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
