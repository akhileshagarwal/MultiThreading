package com.akki.threadlocal;

public class Person {
  public Person(String name) {
	System.out.println(name);
}
  
  public void local(){
	  System.out.println("Local");
  }
}
