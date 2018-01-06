package namoosori.oops.thread.java.step03.interference2;

class SyncCounter {
	//
	private int amount;

	public SyncCounter() {
		//
		this.amount = 0;
	}

	synchronized public int increase() {
		//
		return ++amount;
	}

	synchronized public int decrease() {
		//
		return --amount;
	}

	public synchronized int getAmount() {
		//
		return amount;
	}
}