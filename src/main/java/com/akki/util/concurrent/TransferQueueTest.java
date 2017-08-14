package com.akki.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;



public class TransferQueueTest {
	public static void main(String[] args) {
		TransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}
}

class Consumer implements Runnable {

	private TransferQueue<Integer> queue;

	public Consumer(TransferQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
			try {
				Thread.currentThread().sleep(5000);
				Integer fecthedInt = queue.take();
				System.out.println(Thread.currentThread().getName() + " ** Fetched Value=" + fecthedInt);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

class Producer implements Runnable {

	private TransferQueue<Integer> queue;

	public Producer(TransferQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
			try {
				queue.transfer(99);
				System.out.println(Thread.currentThread().getName() + " ** Value Inserted = " + 99);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
