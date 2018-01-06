package namoosori.oops.thread.java.step02.wait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import namoosori.oops.util.java.Narrator;
import namoosori.oops.util.java.Player;
import namoosori.oops.util.java.TalkingAt;

public class BookReader implements Runnable, Player {
	// 
	private String threadName; 
	private Book book; 
	
	private Narrator narrator; 
	
	public BookReader(Book book) {
		//
		this.book = book; 
	}
	
	public void setThreadName(String threadName) {
		// 
		this.threadName = threadName; 
	}
	
	public String getName() {
		// 
		return threadName; 
	}
	
	public void run() {
		//
		this.narrator = new Narrator(this, TalkingAt.Right); 
		Iterator<String> bookIter = book.iterator(); 
		
		while(bookIter.hasNext()) {
			// 
			if (!sleepWellInSeconds(2)) {
				break; 
			}
			
			narrator.say(bookIter.next());
		}
		narrator.say("End...");
	}
	 
	private boolean sleepWellInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
			return true; 
		} catch (InterruptedException e) {
			narrator.say("I've got an Interrupt.");  
			return false; 
		} 
	}
}