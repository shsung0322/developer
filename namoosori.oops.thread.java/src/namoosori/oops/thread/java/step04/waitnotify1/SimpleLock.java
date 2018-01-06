package namoosori.oops.thread.java.step04.waitnotify1;

public class SimpleLock {
	//
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		//
		while (isLocked) {
			System.out.println("Waiting..."); 
			wait();
			System.out.println("Stop waiting...");  
		}
		isLocked = true;
		System.out.println("Locked..."); 
	}

	public synchronized void unlock() {
		//
		if(!isLocked) {
			return; 
		}
		
		isLocked = false;
		notify();
		System.out.println("Unlock and notifying...");
	}
}