package old.ch05.step01.visibility;

public class Visibility extends Thread {

	private int value;
	private boolean valueExistence;
	
	public static void main(String[] args) {
		
		Visibility v = new Visibility();
		v.start();
		
		v.value = 100;
		v.valueExistence = true;
	}
	
	public void run() {
		while (!valueExistence) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(value);
	}
}
