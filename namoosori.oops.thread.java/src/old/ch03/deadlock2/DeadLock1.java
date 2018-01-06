package old.ch03.deadlock2;

public class DeadLock1 implements Runnable {
	
	public static DeadLock1 instance = new DeadLock1();
	
	private DeadLock1() {
		
	}
	public static DeadLock1 getInstance() {
		return instance;
	}
	
	public void run() {
		dead1();
	}
	
	public synchronized void dead1() {
		System.out.println("Start DeadLock1 -> daed1");
		DeadLock2.getInstance().dead2();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End DeadLock1 -> daed1");
	}

	public synchronized void dead2() {
		System.out.println("Start DeadLock1 -> daed2");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End DeadLock1 -> daed2");
	}
}
