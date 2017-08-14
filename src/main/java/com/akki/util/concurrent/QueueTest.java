package com.akki.util.concurrent;

import java.util.Queue;
import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

	public static void main(String[] args) {
		arrayBlockingQueue();

	}
	
	
	/**
	 * Cannot insert null. 
	 */
	public static void arrayBlockingQueue(){
		Queue<String> arrayBlockingQueue=new ArrayBlockingQueue<>(6);
		arrayBlockingQueue.addAll(CreateList.getList());
		//arrayBlockingQueue.add(null);
		//arrayBlockingQueue.forEach(System.out::println);
		Spliterator<String> spliterator=arrayBlockingQueue.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		spliterator1.forEachRemaining(System.out::println);
		System.out.println(spliterator1.estimateSize());
		spliterator.forEachRemaining(System.out::println);
		
	}

}
