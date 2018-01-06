package namoosori.oops.fileserver.stage1.step3.server.handler;


import namoosori.oops.fileserver.stage1.step3.server.repo.FileStore;
import namoosori.oops.fileserver.stage1.util.RequestMessage;
import namoosori.oops.fileserver.stage1.util.ResponseMessage;

public class FileFindHandler implements FileHandler {
	//
	public FileFindHandler() {
		// 
		
	}
	
	@Override
	public ResponseMessage handle(RequestMessage request) {
		// 
		FileStore fileStore = getFileStore(); 
		String fileName = request.getValue(); 
		
		char[] fileContents = fileStore.readFile(fileName); 
		
		return new ResponseMessage(request.getServiceName(), String.valueOf(fileContents)); 
	}

	public FileStore getFileStore() {
		// 
		return FileStore.newInstance(); 
	}
}