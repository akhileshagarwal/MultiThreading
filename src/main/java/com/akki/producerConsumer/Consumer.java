package com.akki.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Integer fecthedInt = queue.take();
				System.out.println(Thread.currentThread().getName() + " ** Fetched Value=" + fecthedInt);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
