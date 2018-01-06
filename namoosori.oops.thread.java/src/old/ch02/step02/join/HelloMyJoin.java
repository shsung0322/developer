package old.ch02.step02.join;

import java.util.concurrent.TimeUnit;

public class HelloMyJoin {
	//
	public static void main(String[] args) {
		// 
		HelloMyJoin hello = new HelloMyJoin(); 
		hello.startDemo(); 
	}
	
	public void startDemo() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		JoinMultiplier multiplier = new JoinMultiplier("JoinMultiplier");
		
		try {
			multiplier.start();

			//--------------------------------
			multiplier.join();
			//--------------------------------
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		sleepInSeconds(3);
		
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