package namoosori.oops.thread.java.step02.daemon2;

import java.util.concurrent.TimeUnit;

public class AutoSaver extends Thread {
	//
	private Editor editor; 
	
	public AutoSaver(String name, Editor editor) {
		//
		super(name);
		this.editor = editor; 
	}
	
	@Override
	public void run() {
		//
		System.out.println(getName() + ": Started...");
		
		while(true) {
			save();
			if(isInterrupted(2)) {
				break; 
			}
		}
		
		System.out.println(getName() + ": End...");
	}
	
	private void save() {
		//
		System.out.println(editor.getBuilder().toString() + " --> is saved."); 
	}
	
	private boolean isInterrupted(int seconds) {
		// 
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			return true;
		}
		
		return false; 
	}
}