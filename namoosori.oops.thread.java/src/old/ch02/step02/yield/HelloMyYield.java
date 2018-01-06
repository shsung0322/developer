package old.ch02.step02.yield;

import java.util.concurrent.TimeUnit;

public class HelloMyYield {
	//
	public static void main(String[] args) {
		// 
		HelloMyYield hello = new HelloMyYield(); 
		hello.startDemo(); 
	}
	
	public void startDemo() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		Summarizer summerizer = new Summarizer("Summerizer"); 
		Multiplier multiplier = new Multiplier("Multiplier");
		
		summerizer.start();
		multiplier.start();
	
		while (true) {
			//
			if (summerizer.isAlive() && multiplier.isAlive()) {
				sleepInSeconds(1);
				continue; 
			} 
			break; 
		}
		
		System.out.println("\n" + Thread.currentThread().getName() + ": End...\n");
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