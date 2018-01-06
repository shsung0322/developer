package old.ch04.step02.synccounter.integer;

public class SyncInteger {

	private int value;
	
	public SyncInteger(int value) {
		this.value = value;
	}
	

	public synchronized void plusOne() {
		value++;
	}
	
	public synchronized void plusValue(int value) {
		this.value += value;
	}
	
	public synchronized int get() {
		return value;
	}
}
