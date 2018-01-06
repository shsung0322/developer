package namoosori.oops.thread.java.step02.wait;

import namoosori.oops.util.java.Narrator;
import namoosori.oops.util.java.Player;
import namoosori.oops.util.java.TalkingAt;

public class BookDirector implements Player {
	//
	private long patienceInMillis;
	private Narrator narrator;

	public BookDirector(int patienceInSeonds) {
		//
		this.patienceInMillis = (1000 * patienceInSeonds);
		this.narrator = new Narrator(this, TalkingAt.Left);
	}

	public Thread startReading() {
		//
		Book tearsInHeaven = new Book("Tears in Heaven");
		BookReader bookReader = new BookReader(tearsInHeaven);
		Thread bookReaderThread = new Thread(bookReader);
		bookReader.setThreadName(bookReaderThread.getName());
		bookReaderThread.start();

		return bookReaderThread;
	}

	public void waitAndBePatient(Thread bookReaderThread) throws InterruptedException {
		//
		long start = System.currentTimeMillis();

		while (bookReaderThread.isAlive()) {
			//
			narrator.say("I'm generouse so I'm waiting...");
			bookReaderThread.join(5000);
			long current = System.currentTimeMillis();

			if ((current - start) > this.patienceInMillis) {
				if (bookReaderThread.isAlive()) {
					narrator.say("I can't take it anymore, sorry but iterrupt !!!");
					bookReaderThread.interrupt();
					bookReaderThread.join();
				}
			}
		}

		narrator.say("End...");
	}

	@Override
	public String getName() {
		//
		return Thread.currentThread().getName();
	}
}
