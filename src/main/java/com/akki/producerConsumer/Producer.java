package com.akki.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue=queue;
	}

	public void run() {
		for(int i=0;i<20;i++){
			try {
				queue.put(i);
				System.out.println(Thread.currentThread().getName()+" ** Value Inserted = "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
