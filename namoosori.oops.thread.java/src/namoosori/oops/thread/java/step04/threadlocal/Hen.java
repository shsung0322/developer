package namoosori.oops.thread.java.step04.threadlocal;

import java.util.concurrent.TimeUnit;

public class Hen implements Runnable {
	//
	private ThreadLocal<Integer> egg; 
	private String name; 

	public Hen(String name) {
		// 
		this.name = name; 
		this.egg = new ThreadLocal<Integer>();
	}
	
	@Override
	public void run() {
		//
		egg.set((int) (Math.random() * 100D));
		sleepInMillis(500);

		String threadName = Thread.currentThread().getName(); 
		System.out.format("%s|%s| %d %n", threadName, name, egg.get());
	}
	
	private void sleepInMillis(int millis) {
		// 
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}