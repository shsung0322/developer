package namoosori.oops.fileserver.stage1.step3.server.react;

import java.net.Socket;

public class EventInfo {
	//
	private long sequence; 
	private Socket socket; 
	
	public EventInfo(long sequence, Socket socket) {
		// 
		this.sequence = sequence; 
		this.socket = socket; 
	}
	
	public Socket getSocket() {
		// 
		return socket; 
	}
	
	public long getSequence() {
		return sequence; 
	}
}