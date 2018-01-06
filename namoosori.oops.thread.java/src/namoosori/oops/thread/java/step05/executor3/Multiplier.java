package namoosori.oops.thread.java.step05.executor3;

import java.util.concurrent.Callable;

public class Multiplier implements Callable<Long> {
	//
	private int baseValue; 
	
	public Multiplier(int baseValue) {
		// 
		this.baseValue = baseValue; 
	}
	
	public Long call() {
		// 
		long result = 1; 
		for (int i=1; i<=baseValue; i++) {
			result *= i; 
		}
		
		return Long.valueOf(result); 
	}
}