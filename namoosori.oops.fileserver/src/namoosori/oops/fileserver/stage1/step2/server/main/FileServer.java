package namoosori.oops.fileserver.stage1.step2.server.main;

import namoosori.oops.fileserver.stage1.step2.context.FileContext;
import namoosori.oops.fileserver.stage1.step2.server.react.FileServerReactor;

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