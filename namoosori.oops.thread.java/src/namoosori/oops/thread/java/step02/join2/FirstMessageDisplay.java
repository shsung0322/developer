package namoosori.oops.thread.java.step02.join2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstMessageDisplay extends Thread {
	//
	private List<String> messages; 
	
	public FirstMessageDisplay(List<String> messages) {
		// 
		this.messages = messages; 
	}
	
	public void run() {
		// 
		for(String message : messages) {
			// 
			if (!sleepWellInSeconds(2)) {
				break; 
			}
			
			System.out.println(getClass().getSimpleName() + ":" + getName() + ": " + message); 
		}

		System.out.println(getClass().getSimpleName() + ":" + getName() + ": End..."); 
	}
	
	private boolean sleepWellInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
			return true; 
		} catch (InterruptedException e) {
			System.out.println(this.getClass().getSimpleName() + ":" + getName() + ": I've got an Interrupt.");  
			return false; 
		} 
	}
}