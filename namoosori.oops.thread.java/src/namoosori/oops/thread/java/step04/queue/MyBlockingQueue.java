package namoosori.oops.thread.java.step04.queue;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {
	//
	private List<String> linkedList; 
	private int capacity;

	public MyBlockingQueue(int capacity){
		//
	    this.capacity = capacity;
	    this.linkedList = new LinkedList<>(); 
	  }

	public synchronized void add(String item) throws InterruptedException {
		//
		while (linkedList.size() >= capacity) {
			System.out.println("[Add] Queue is full, waiting..."); 
			wait();
		}
		
		if (this.linkedList.size() == 0) {
			notifyAll();
		}
		
		System.out.format("%s: Adding %s \n", Thread.currentThread().getName(), item);  
		this.linkedList.add(item);
	}

	public synchronized String take() throws InterruptedException {
		//
		while (linkedList.size() == 0) {
			System.out.println("[Take] No element in Queue, waiting..."); 
			wait(10*1000);
		}
		
		if (linkedList.size() == capacity) {
			notifyAll();
		}

		System.out.format("%s: Taking... \n", Thread.currentThread().getName());  
		return linkedList.remove(0);
	}
}