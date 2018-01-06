package namoosori.oops.thread.java.step02.join2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondMessageDisplay extends Thread {
	//
	private List<String> messages;
	private FirstMessageDisplay previousMessage; 
	
	public SecondMessageDisplay(List<String> messages, FirstMessageDisplay firstMessage) {
		// 
		this.messages = messages; 
		this.previousMessage = firstMessage; 
	}
	
	public void run() {
		// 
		if(joinInterrupted()) {
			return; 
		}
		
		for(String message : messages) {
			// 
			if (!sleepWellInSeconds(2)) {
				break; 
			}
			
			System.out.println(getClass().getSimpleName() + ":" + getName() + ": " + message); 
		}

		System.out.println(getClass().getSimpleName() + ":" + getName() + ": End..."); 
	}
	
	private boolean joinInterrupted() {
		//
		if (previousMessage != null) {
			try { 
				previousMessage.join();
				return false; 
			} catch (InterruptedException e) {
				System.out.println(this.getClass().getSimpleName() + ":" + getName() + ": I've got an Interrupt.");  
				return true; 
			} 
		} else {
			return false; 
		}
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