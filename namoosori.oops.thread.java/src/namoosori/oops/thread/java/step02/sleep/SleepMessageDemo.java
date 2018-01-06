package namoosori.oops.thread.java.step02.sleep;

import java.util.LinkedList;

public class SleepMessageDemo {

	public static void main(String[] args) {
		// 
		startDemo(); 
	}
	
	private static void startDemo() {
		// 
		LinkedList<String> messages = new LinkedList<>(); 
		messages.add("Hello, my friends!"); 
		messages.add("Where are you going?"); 
		messages.add("Don't go anywhere at the moment."); 
		messages.add("You should find your way in this country."); 
		
		SleepMessageDisplay sleepMessageDisplay = new SleepMessageDisplay(messages); 
		sleepMessageDisplay.start(); 

		String threadName = Thread.currentThread().getName(); 
		System.out.println(threadName + ": End... "); 
	}
}