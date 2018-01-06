package old.ch02.step02.scheduling.logging;

public class SchedulingLogger implements Runnable {
	//
	private static int loggerSequence;
	
	private String logText;
	
	private SchedulingLogger(String logText) {
		this.logText = logText;
	}
	
	public static void log(String logText) {
		Thread logThread = new Thread(new SchedulingLogger(logText));
		logThread.start();
	}

	@Override
	public void run() {
		log();
	}
	
	public void log() {
		String loggerPrefix = getClass().getSimpleName() + (loggerSequence++) + "-";
		
		System.out.println(loggerPrefix + Thread.currentThread().isDaemon());
		System.out.println(loggerPrefix + this.logText);

		// Do logging..
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(loggerPrefix + "finish logging");
	}
}
