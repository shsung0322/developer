package old.ch04.step02.synccounter.integer;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExtender extends AtomicInteger {

	private static final long serialVersionUID = -3073949071755488910L;

	public synchronized void plusOne() {
		super.incrementAndGet();
	}
	
	public synchronized void plusValue(int value) {
		super.addAndGet(value);
	}
}
