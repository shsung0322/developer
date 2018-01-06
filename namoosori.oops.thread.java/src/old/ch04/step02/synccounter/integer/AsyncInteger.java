package old.ch04.step02.synccounter.integer;

public class AsyncInteger {

	volatile private int value;
	
	public AsyncInteger(int value) {
		this.value = value;
	}
	

	public synchronized void plusOne() {
		value++;
	}
	
	public synchronized void plusValue(int value) {
		this.value += value;
	}
	
	public int get() {
		return value;
	}
}
