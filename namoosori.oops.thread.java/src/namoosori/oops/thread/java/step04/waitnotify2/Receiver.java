package namoosori.oops.thread.java.step04.waitnotify2;

import java.util.Random;

public class Receiver extends Thread {
	//
	private MessageBox messageBox;
	private Random random;

	public Receiver(MessageBox messageBox) {
		//
		this.messageBox = messageBox;
		this.random = new Random();
	}

	public void run() {
		//
		int randomInt = 0; 
		while(true) {
			String message = messageBox.take();  
			System.out.format("<-- Received | %4d | %s%n", randomInt, message); 
			if (message.equals(MessageBox.END_MESSAGE)) {
				break; 
			}
			randomInt = sleepRandom(); 
		}
	}

	private int sleepRandom() {
		//
		int randomInt = random.nextInt(3000); 
		try {
			Thread.sleep(randomInt);
		} catch (InterruptedException e) {
			//
		}
		
		return randomInt; 
	}
}
