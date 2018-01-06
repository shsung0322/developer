package old.ch04.step02.synccounter.integer;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerWrapper  {

	private AtomicInteger integer;
	
	public synchronized void plusOne() {
		integer.incrementAndGet();
	}
	
	public synchronized void plusValue(int value) {
		integer.addAndGet(value);
	}
	
	public synchronized void incrementAndGet() {
		integer.incrementAndGet();
	}
	
}
