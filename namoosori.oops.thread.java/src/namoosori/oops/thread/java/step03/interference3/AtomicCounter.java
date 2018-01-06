package namoosori.oops.thread.java.step03.interference3;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
	//
	private AtomicInteger amount;

	public AtomicCounter() {
		//
		this.amount = new AtomicInteger(0);
	}

	public void increase() {
		//
		amount.incrementAndGet();
	}

	public void decrease() {
		//
		amount.decrementAndGet();
	}

	public int getAmount() {
		//
		return amount.get();
	}
}