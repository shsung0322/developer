package namoosori.oops.thread.java.step02.interrupt1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterruptDemo1 {
	//
	private List<String> messages = new ArrayList<>(); 

	public static void main(String[] args) throws InterruptedException {
		// 
		InterruptDemo1 demo1 = new InterruptDemo1(); 
		demo1.prepareMessages(); 
		demo1.show();  
	}
	
	public void show() throws InterruptedException {
		// 
		String threadName = Thread.currentThread().getName(); 
		System.out.println(threadName + ": Started... \n"); 

		MessageDisplay messageDisplay = new MessageDisplay(messages); 
		messageDisplay.start(); 

		TimeUnit.SECONDS.sleep(6);
		
		System.out.println("\n" + threadName + ": Interrupting... "); 
		messageDisplay.interrupt(); 
		
		System.out.println("\n" + threadName + ": End... "); 
	}
	
	public void prepareMessages() {
		// 
		messages.add("Hello, my friends!"); 
		messages.add("Where are you going?"); 
		messages.add("Don't go anywhere at the moment."); 
		messages.add("You should find your way in this country."); 
		messages.add("Can you hear me?"); 
		messages.add("My friends!"); 
	}
}