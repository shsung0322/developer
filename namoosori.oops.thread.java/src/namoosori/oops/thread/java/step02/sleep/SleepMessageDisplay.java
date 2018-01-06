package namoosori.oops.thread.java.step02.sleep;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SleepMessageDisplay extends Thread {
	//
	private LinkedList<String> messages; 
	
	public SleepMessageDisplay(LinkedList<String> messages) {
		// 
		this.messages = messages; 
	}
	
	public void run() {
		// 
		String threadName = this.getClass().getSimpleName() + ":" + getName();
		
		while(true) {
			try {
				String message = messages.removeFirst(); 
				System.out.println(threadName + ": " + message); 
			} catch (NoSuchElementException e) {
				break; 
			}
			
			sleepInSeconds(4);
		}
		System.out.println(threadName + ": Bye..."); 
	}
	
	private void sleepInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}