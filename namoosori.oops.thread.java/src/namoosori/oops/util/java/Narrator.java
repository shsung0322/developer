/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package namoosori.oops.util.java;

public class Narrator {
	//
	private String playerName; 
	private String playerClass; 
	private TalkingAt position; 
	private boolean silentMode; 

	public Narrator(Player player, TalkingAt position) {
		//
		this.playerName = player.getName();
		this.playerClass = player.getClass().getSimpleName(); 
		this.position = position; 
	}

	public void keepSilent() {
		// 
		this.silentMode = true; 
	}

	public void keepTalktive() {
		// 
		this.silentMode = false; 
	}

	public void say (String message) {
		// 
		printOut(appendTabs().append(formatMessage(message)).append("\n")); 
	}

	public void sayAndSleep (String message, int seconds) {
		// 
		say(message); 
		sleep(seconds); 
	}

	public void sayNewLine() {
		//
		System.out.print("\n"); 
	}
	
	private void printOut(StringBuffer message) {
		// 
		if (!silentMode) {
			System.out.print(message.toString()); 
		} else {
			System.out.print("*"); 
		}
	}
	
	private String formatMessage(String message) {
		// 
		return String.format(" <%s:%s> %s", playerName, playerClass, message); 
	}
	
	private StringBuffer appendTabs () {
		//
		StringBuffer buffer = new StringBuffer(); 
		
		for (int i=0; i<this.position.tabCount(); i++) {
			buffer.append("\t"); 
		}
		
		return buffer; 
	}
	
	private void sleep(int seconds) {
		// 
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}