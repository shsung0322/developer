package namoosori.oops.fileserver.stage1.step3.server.main;

import namoosori.oops.fileserver.stage1.step3.context.FileContext;
import namoosori.oops.fileserver.stage1.step3.server.react.FileServerReactor;

public class FileServer {
	//
	public static void main(String[] args) {
		// 
		startServer(); 
	}
	
	private static void startServer() {
		// 
		FileServerReactor reactor = new FileServerReactor(); 
		reactor.start(); 
		System.out.println("FileServer is started... " + FileContext.STEP_NAME); 
	}
}