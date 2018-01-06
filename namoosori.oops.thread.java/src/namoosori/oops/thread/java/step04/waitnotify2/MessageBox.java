package namoosori.oops.thread.java.step04.waitnotify2;

public class MessageBox {
	//
	public static final String END_MESSAGE = "End";

	private String message;
	private boolean empty;

	public MessageBox() {
		//
		this.empty = true;
	}

	public synchronized String take() {
		// Guarded block
		//
		while (empty) {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.format("# Waiting to take | %s | ....%n", threadName);
				wait();
			} catch (InterruptedException e) {
				//
			}
		}

		empty = true;
		notifyAll();

		return message;
	}

	public synchronized void put(String message) {
		// Guarded block
		//
		while (!empty) {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.format("# Waiting to put | %s | ....%n", threadName);
				wait();
			} catch (InterruptedException e) {
				//
			}
		}

		empty = false;
		this.message = message;

		notifyAll();
	}
}