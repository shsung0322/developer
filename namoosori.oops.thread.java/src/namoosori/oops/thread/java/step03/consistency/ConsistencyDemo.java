package namoosori.oops.thread.java.step03.consistency;

import java.util.concurrent.TimeUnit;

public class ConsistencyDemo {
	//
	public static void main(String[] args) {
		// 
		ConsistencyDemo demo = new ConsistencyDemo(); 
		demo.startDemo(); 
	}
	
	private void startDemo() {
		// 
		SingleValue singleValue = new SingleValue();  
		
		Addition addition = new Addition(singleValue); 
		JustPrinter printer = new JustPrinter(singleValue);
		
		printer.start(); 
		addition.start();
	}
	
	private void sleepWellInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
		} 
	}
	
	class Addition extends Thread {
		// 
		private SingleValue value; 
		
		public Addition(SingleValue value) {
			//
			this.value = value; 
		}
		
		public void run() {
			//
			int count = 0; 
			while(true) {
				if (count++ == 10) {
					break; 
				}
				this.value.increase(); 
				System.out.format("%s: Addition: value is: %s \n", getName(), value.getValue()); 
				sleepWellInSeconds(2); 
			}
			System.out.format("%s: Bye... ", getName()); 
		}
	}
	
	class JustPrinter extends Thread {
		// 
		private SingleValue value; 
		
		public JustPrinter(SingleValue value) {
			this.value = value; 
		}
		
		public void run() {
			//
			int count = 0; 
			while(true) {
				if (count++ == 10) {
					break; 
				}
				
				System.out.format("%s: JustPrinter: value is: %s \n", getName(), value.getValue()); 
				sleepWellInSeconds(2); 
			}

			System.out.format("%s: Bye... ", getName()); 
		}
	}
}