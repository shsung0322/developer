package old.ch03.deadlock2;

public class DeadLock2 implements Runnable {

	public static DeadLock2 instance = new DeadLock2();
	
	private DeadLock2() {
		
	}
	public static DeadLock2 getInstance() {
		return instance;
	}
	
	public void run() {
		dead1();
	}
	
	
	public synchronized void dead1() {
		System.out.println("Start DeadLock2 -> daed1");
		DeadLock1.getInstance().dead2();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End DeadLock2 -> daed1");
	}
	
	public synchronized void dead2() {
		System.out.println("Start DeadLock2 -> daed2");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End DeadLock2 -> daed2");
	}
}
