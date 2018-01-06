package namoosori.oops.thread.java.step02.join1;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// 
		startDemo(); 
	}
	
	private static void startDemo() throws InterruptedException {
		// 
		String threadName = Thread.currentThread().getName(); 
		System.out.println("JoinDemo1:" + threadName + ": Started... \n"); 

		List<String> messages = new ArrayList<>(); 
		messages.add("Hello, my friends!"); 
		messages.add("Where are you going?"); 
		messages.add("Don't go anywhere at the moment."); 
		messages.add("You should find your way in this country."); 
		
		MessageDisplay messageDisplay = new MessageDisplay(messages); 
		messageDisplay.start(); 

		//
		// main 스레드가 messageDisplay 뒤에 줄을 섭니다. 
		//
		messageDisplay.join(); 		// throw InterruptException
		
		System.out.println("\n JoinDemo1:" + threadName + ": End... "); 
	}
}