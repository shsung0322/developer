package old.ch03.deadlock1;

import java.util.concurrent.TimeUnit;

import namoosori.oops.util.java.Narrator;
import namoosori.oops.util.java.Player;
import namoosori.oops.util.java.TalkingAt;

public class Customer extends Thread implements Player {
	//
	private Merchant merchant; 
	private Product product; 
	
	private Narrator narrator; 
	
	public Customer(String name) {
		// 
		super(name);
		this.narrator = new Narrator(this, TalkingAt.Left); 
	}
	
	public void setMerchant(Merchant merchant) {
		// 
		this.merchant = merchant; 
		this.product = null; 
	}
	
	public void run() {
		// 
		while(true) {
			// 
			sleepInMillis(1000);
			
			if (requestProduct() != null) {
				break; 
			}; 
		}
	}
	
	public synchronized Product requestProduct() {
		//
		narrator.say("Request the product to merchant.");

		sleepInMillis(100);
		if (product == null) {
			narrator.say("No product, so I request the product..."); 
			merchant.requestProduct();  
		} 

		return new Product(); 
	}

	public synchronized Money requestMoney() {
		//
		System.out.println(getName() + ": requested the money from merchant.");

		if (product == null) {
			narrator.say("No product, so I request the product..."); 
			this.product = merchant.requestProduct(); 
		} 
		
		return new Money(); 
	}

	private void sleepInMillis(int millis) {
		// 
		try {
			System.out.println(getName() + ": sleep in " + millis + " millis");
			TimeUnit.MICROSECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}