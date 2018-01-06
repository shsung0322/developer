package namoosori.oops.thread.java.step04.waitnotify2;

import java.util.Iterator;
import java.util.Random;

public class Sender extends Thread {
	//
	private MessageBox messageBox;
	private Random random; 


	public Sender(MessageBox messageBox) {
		//
		this.messageBox = messageBox;
		this.random = new Random(); 
	}

	public void run() {
		//
		Iterator<String> messageIter = new MessageBook().iterator();

		while (messageIter.hasNext()) { 
			//
			String message = messageIter.next(); 
			messageBox.put(message);
			System.out.format("--> Send | %s%n", message); 
			sleepRandom(); 
		}
		
		messageBox.put(MessageBox.END_MESSAGE);
	}
	
	private void sleepRandom() {
		// 
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			//
		}
	}
}