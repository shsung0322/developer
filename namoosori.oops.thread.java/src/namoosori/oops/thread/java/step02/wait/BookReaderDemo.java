package namoosori.oops.thread.java.step02.wait;

public class BookReaderDemo {
	//
	public static void main(String[] args) throws InterruptedException {
		// 
		startDemo(); 
	}
	
	private static void startDemo() throws InterruptedException {
		//
		int patienceInSedonds = 20; 
		BookDirector bookDirector = new BookDirector(patienceInSedonds); 
		
		Thread bookReader = bookDirector.startReading(); 
		bookDirector.waitAndBePatient(bookReader); 
	}
}