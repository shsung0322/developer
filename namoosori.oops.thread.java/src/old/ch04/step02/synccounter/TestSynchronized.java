package old.ch04.step02.synccounter;

public class TestSynchronized {

	private int count;
	
	public static void main(String[] args) {
		
		final int countOfRoopt = 10;
		
		TestSynchronized test = new TestSynchronized();
		Thread thread = null;
		
		for (int i = 0; i < countOfRoopt; i++) {
			thread = new Thread(new Runnable() {
				public void run() {
					test.increaseCount();
				}
			}, "increament-" + i);
			thread.start();
		}
		for (int i = 0; i < countOfRoopt; i++) {
			thread = new Thread(new Runnable() {
				public void run() {
					test.increaseCount(10);
				}
			}, "increament-" + i);
			thread.start();
		}
		
		for (int i = 0; i < countOfRoopt; i++) {
			thread = new Thread(new Runnable() {
				public void run() {
					System.out.println(test.getCount());
				}
			}, "get-" + i);
			thread.start();
		}
	    
	}
	
	
	public synchronized void increaseCount() {
		System.out.println("Start increase");
		int localCount = this.count;
		localCount = localCount + 1;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.count = localCount;
		System.out.println(Thread.currentThread().getName() + "-count: " + this.count);
		System.out.println("End incrrease");
	}
	
	public synchronized void increaseCount(int i) {
		System.out.println("Start increase2");
		int localCount = this.count;
		localCount = localCount + i;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.count = localCount;
		System.out.println(Thread.currentThread().getName() + "-count: " + this.count);
		System.out.println("End increase2");
	}
	
	public  int getCount() {
		System.out.println("Start get Count " + Thread.currentThread().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End get Count " + Thread.currentThread().getName());
		return count;
	}
	
	
}
