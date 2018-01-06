package namoosori.oops.thread.java.step02.daemon2;

import java.util.concurrent.TimeUnit;

public class Editor {
	//
	private StringBuilder builder = new StringBuilder(); 
	
	public static void main(String[] args) {
		// 
		Editor editor = new Editor(); 
		editor.showDemo(); 
	}
	
	public StringBuilder getBuilder() {
		// 
		return builder; 
	}
	
	public void showDemo() {
		//
		System.out.println(Thread.currentThread().getName() + ": Started...\n");
		
		AutoSaver autoSaver = new AutoSaver("AutoSaver", this);
		
		//--------------------------------
		// main 스레드가 종료되면 자동/강제 종료
		// 예, 자동저장 기능 
		autoSaver.setDaemon(true); 
		//--------------------------------
		
		autoSaver.start();
		for(int i=0; i<10; i++) {
			this.builder.append(" [i=" + i + "] ");
			sleepInSeconds(1);
		}
		
		System.out.println("\n" + Thread.currentThread().getName() + ": End...\n");
	}
	
	private void sleepInSeconds(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}