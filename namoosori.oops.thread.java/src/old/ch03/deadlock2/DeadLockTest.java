package old.ch03.deadlock2;

public class DeadLockTest {

	public static void main(String[] args) {
		
		Thread th1 = new Thread(DeadLock1.getInstance());
		Thread th2 = new Thread(DeadLock2.getInstance());
		
		th1.start();
		th2.start();
	}
}
