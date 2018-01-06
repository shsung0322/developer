package namoosori.oops.thread.java.step02.interrupt2;

public class NumberAccumulator extends Thread {
	//
	public NumberAccumulator() {
		// 
	}
	
	public void run() {
		// 
		int count = 0; 
		while(true) {
			// 
			doHeavyCalculation(); 
			
			if (Thread.interrupted()) {  
				// same with "if (this.isInterrupted()) {"
				System.out.println(this.getClass().getSimpleName() + ":" + getName() + ": Interrupted -> " + count); 
				break; 
			}
			System.out.println(String.format("%d times calculation.", count++)); 
		}

		System.out.println(this.getClass().getSimpleName() + ":" + getName() + ": End..."); 
	}
	
	private int doHeavyCalculation() {
		// 
		int sum = 0; 
		for(int i=0; i<1000000000; i++) {
			sum += i; 
		}
		
		return sum; 
	}
}