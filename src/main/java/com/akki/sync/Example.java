package com.akki.sync;

public class Example {
	 public static void main(String[] args){
	      Counter counter = new Counter();
	      Thread  threadA = new CounterThread(counter);
	      Thread  threadB = new CounterThread(counter);
threadA.setName("A");
threadB.setName("B");
	      threadA.start();
	      threadA.start();
	      threadB.start(); 
	    }
}
