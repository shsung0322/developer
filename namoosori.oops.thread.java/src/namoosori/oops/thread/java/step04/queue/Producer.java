package namoosori.oops.thread.java.step04.queue;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
	// 
	private MyBlockingQueue queue; 
	
	public Producer(MyBlockingQueue queue) {
		//
		this.queue = queue; 
	}
	
	public void run() {
		// 
		Iterator<String> messageIter = new MessageBook().iterator(); 
		
		while(messageIter.hasNext()) {
			//
			try {
				queue.add(messageIter.next());				
			} catch (InterruptedException e) {
				e.printStackTrace();
				break; 
			} 
			
			sleepInMills(100); 
		}
	}
	
	public void sleepInMills(int millis) {
		// 
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}