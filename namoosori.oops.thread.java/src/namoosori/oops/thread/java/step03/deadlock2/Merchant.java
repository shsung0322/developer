package namoosori.oops.thread.java.step03.deadlock2;

import java.util.concurrent.TimeUnit;

import namoosori.oops.util.java.Narrator;
import namoosori.oops.util.java.Player;
import namoosori.oops.util.java.TalkingAt;

public class Merchant extends Thread implements Player {
	//
	private Customer customer; 
	private Money money; 

	private Narrator narrator; 
	
	public Merchant(String name) {
		//
		super(name); 
		this.narrator = new Narrator(this, TalkingAt.Right); 
}
	
	public void setCustomer(Customer customer) {
		// 
		this.customer = customer; 
		this.money = null; 
	}
	
	public void run() {
		// 
		while(true) {
			sleepInMillis(1000); 
			if(requestMoney() != null) {
				break; 
			}; 
		}
	}
	
	public Money requestMoney() {
		//
		narrator.say("Request money to customer.");
		
		sleepInMillis(100);
		if (money == null) {
			narrator.say("No money, so I request money..."); 
			this.money = customer.requestMoney(); 
		}
		
		return money; 
	}

	public synchronized Product requestProduct() {
		//
		narrator.say(getName() + ": requested product from customer.");

		if (money == null) {
			narrator.say("No money, so I request money..."); 
			this.money = customer.requestMoney(); 
		} 

		return new Product(); 
	}
	
	private void sleepInMillis(int millis) {
		// 
		try {
			TimeUnit.MICROSECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
