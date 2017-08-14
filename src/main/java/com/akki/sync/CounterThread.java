package com.akki.sync;

public class CounterThread extends Thread {
	 protected Counter counter = null;

     public CounterThread(Counter counter){
        this.counter = counter;
     }

     public void run() {
	for(int i=0; i<10; i++){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" thread Adding ="+i);
           counter.add(i);
           
        }
     }
}
