package namoosori.oops.thread.java.step03.sync.sync3;

public class CoffeeAddict extends Thread {
	//
	private String favorite; 
	
	private Cafe cafe; 
	
	public CoffeeAddict(String name, String favorite) {
		// 
		super(name); 
		this.favorite = favorite; 
	}
	
	public void visitCafe(Cafe cafe) {
		// 
		System.out.format("%s: %s enter to %s \n", getName(), getName(), cafe.getName()); 
		this.cafe = cafe; 
	}
	
	public void run() {
		// 
		while(true) {
			// 
			System.out.format("%s is ordered %s \n", getName(), favorite);
			cafe.order(getName(), favorite);
			break; 
		}
	}
}