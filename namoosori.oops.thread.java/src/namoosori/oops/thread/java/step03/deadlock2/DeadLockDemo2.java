package namoosori.oops.thread.java.step03.deadlock2;

public class DeadLockDemo2 {

	public static void main(String[] args) {
		//
		DeadLockDemo2 demo = new DeadLockDemo2(); 
		demo.start(); 
	}
	
	public void start() {
		// 
		Merchant smith = new Merchant("Smith");
		Customer hanseol = new Customer("Hanseol");
		
		smith.setCustomer(hanseol);
		hanseol.setMerchant(smith);
		
		smith.start();
		hanseol.start();
	}
}