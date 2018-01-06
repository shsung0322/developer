package namoosori.oops.thread.java.step02.join2;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// 
		startDemo(); 
	}
	
	private static void startDemo() throws InterruptedException {
		// 
		String threadName = Thread.currentThread().getName(); 
		System.out.println(threadName + ": Started... \n"); 
		
		FirstMessageDisplay firstMessage = startFirstMessage();
		SecondMessageDisplay secondMessage = startSecondMessage(firstMessage);
		
		firstMessage.start();
		secondMessage.start();
		
		secondMessage.join(); 
		
		System.out.println("\n" + threadName + ": End... "); 
	}
	
	private static FirstMessageDisplay startFirstMessage() {
		//
		List<String> messages = new ArrayList<>(); 
		messages.add("Frist: Hello, my friends!"); 
		messages.add("First: Where are you going?"); 
		messages.add("First: Don't go anywhere at the moment."); 
		messages.add("First: You should find your way in this country."); 
		
		return new FirstMessageDisplay(messages); 
	}
	
	private static SecondMessageDisplay startSecondMessage(FirstMessageDisplay firstMessage) {
		//
		List<String> messages = new ArrayList<>(); 
		messages.add("Second: Hello, my friends!"); 
		messages.add("Second: Where are you going?"); 
		messages.add("Second: Don't go anywhere at the moment."); 
		messages.add("Second: You should find your way in this country."); 
		
		return new SecondMessageDisplay(messages, firstMessage); 
	}
}