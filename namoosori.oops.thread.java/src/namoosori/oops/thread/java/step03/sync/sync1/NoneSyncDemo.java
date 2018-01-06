package namoosori.oops.thread.java.step03.sync.sync1;

public class NoneSyncDemo {
	//
	public static void main(String[] args) {
		// 
		NoneSyncDemo demo = new NoneSyncDemo(); 
		try {
			demo.show();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public void show() throws InterruptedException {
		// 
		long start = System.currentTimeMillis(); 
		Cafe hollys = new Cafe("hollys"); 
		
		CoffeeAddict steve = new CoffeeAddict("Steve", "Americano"); 
		CoffeeAddict jane = new CoffeeAddict("Jane", "Hot Chocho"); 
		CoffeeAddict tim = new CoffeeAddict("Tim", "Apple juice"); 
		CoffeeAddict jemins = new CoffeeAddict("Jemins", "Red tea"); 
	
		steve.visitCafe(hollys);
		jane.visitCafe(hollys);
		tim.visitCafe(hollys);
		jemins.visitCafe(hollys);
		
		steve.start(); 
		jane.start(); 
		tim.start(); 
		jemins.start();
		
		steve.join(); 
		jane.join(); 
		tim.join();
		jemins.join(); 
		
		System.out.format("Order count: %d \n",hollys.getOrderCount()); 
		System.out.format("Orders are : %s \n", hollys.getAllOrders().toString());
		System.out.format("Order time is : %d milliseconds \n", System.currentTimeMillis() - start);
		
		System.out.format("%s: End...", Thread.currentThread().getName()); 
	}
}