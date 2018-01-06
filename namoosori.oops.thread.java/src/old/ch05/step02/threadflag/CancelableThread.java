package old.ch05.step02.threadflag;

public class CancelableThread extends Thread {

	public static void main(String[] args) {
		CancelableThread thread = new CancelableThread();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		thread.interrupt();
		thread.canceled = true;
	}
	
	private boolean canceled;
	
	public void run() {
		cancelByFlag();
	}
	
	// 1. 인터럽트를 이용한 쓰레드 종료
	public void cancelByinterrupt() {
		while (true) {
			System.out.println("Execute logic..");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Exit");
				return;
			}
		}
	}
	
	public void cancelByFlag() {
		while (true) {
			System.out.println("Execute logic2...");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			if (canceled) {
				System.out.println("Exit2");
				return;
			}
		}
		
	}
}
