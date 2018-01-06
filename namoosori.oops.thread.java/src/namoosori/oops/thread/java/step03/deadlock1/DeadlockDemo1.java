package namoosori.oops.thread.java.step03.deadlock1;

import java.util.concurrent.TimeUnit;

public class DeadlockDemo1 {
	//
	public static void main(String[] args) {
		//
		DeadlockDemo1 demo = new DeadlockDemo1(); 
		demo.show(); 
	}
	
	public void show() {
		// 
		final Friend terry = new Friend("Terry");
		final Friend steve = new Friend("Steve");
		
		new Thread(new Runnable() {
			public void run() {
				terry.sayHello(steve);
			}
		}).start();
		
		sleepInSeconds(2);
		
		new Thread(new Runnable() {
			public void run() {
				steve.sayHello(terry);
			}
		}).start();
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
