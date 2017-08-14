package com.akki.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(10);
		Thread producer=new Thread(new Producer(queue));
		Thread consumer=new Thread(new Consumer(queue));
		producer.start();
		consumer.start();

	}

}
