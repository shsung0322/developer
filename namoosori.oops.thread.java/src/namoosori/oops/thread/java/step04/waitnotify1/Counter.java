package namoosori.oops.thread.java.step04.waitnotify1;

class Counter {
	//
	private int amount;
	private SimpleLock lock;

	public Counter() {
		//
		this.amount = 0;
		this.lock = new SimpleLock();
	}

	public void increase() throws InterruptedException {
		//
		lock.lock();
		amount++;
		lock.unlock();
	}

	public void decrease() throws InterruptedException {
		//
		lock.lock();
		amount--;
		lock.unlock();
	}

	public int getAmount() {
		//
		return amount;
	}
}