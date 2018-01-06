package namoosori.oops.thread.java.step04.waitnotify2;

public class MessageBoxDemo {
	//
	public static void main(String[] args) {
		// 
		startDemo(); 
	}
	
	private static void startDemo() {
		// 
		MessageBox messageBox = new MessageBox(); 
		
		Sender sender = new Sender(messageBox); 
		Receiver receiver1 = new Receiver(messageBox); 
		Receiver receiver2 = new Receiver(messageBox); 
		
		sender.start(); 
		receiver1.start(); 
		receiver2.start(); 
	}
}