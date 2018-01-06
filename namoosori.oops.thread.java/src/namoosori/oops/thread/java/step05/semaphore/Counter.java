package namoosori.oops.thread.java.step05.semaphore;

import java.util.concurrent.Semaphore;

class Counter {
	//
	private int amount;
	private Semaphore semaphore; // compare to SimpleLock;

	public Counter() {
		//
		this.amount = 0;
		this.semaphore = new Semaphore(1);
	}

	public int next() throws InterruptedException {
		//
		int returnValue;

		semaphore.acquire();
		returnValue = amount++;
		semaphore.release();

		return returnValue;
	}

	public int nextNoGuard() throws InterruptedException {
		//
		amount++;

		return amount;
	}
}