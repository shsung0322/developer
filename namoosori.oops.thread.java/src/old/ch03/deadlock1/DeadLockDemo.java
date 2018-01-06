package old.ch03.deadlock1;

public class DeadLockDemo {

	public static void main(String[] args) {
		//
		DeadLockDemo demo = new DeadLockDemo(); 
		demo.start(); 
	}
	
	public void start() {
		// 
		Merchant smith = new Merchant(" Smith");
		Customer hanseol = new Customer("Hanseol");
		
		smith.setCustomer(hanseol);
		hanseol.setMerchant(smith);
		
		smith.start();
		hanseol.start();
	}
}