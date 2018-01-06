package namoosori.oops.thread.java.step03.consistency;

public class SingleValue {
	//
	private int value = 0; 
	
	public SingleValue() {
	}
	
	public int getValue() {
		return value; 
	}
	
	public void increase() {
		value++; 
	}
}