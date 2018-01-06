package namoosori.oops.fileserver.stage1.step2.server.handler;


import namoosori.oops.fileserver.stage1.step2.server.repo.FileStore;
import namoosori.oops.fileserver.stage1.util.RequestMessage;
import namoosori.oops.fileserver.stage1.util.ResponseMessage;

public class FileDeleteHandler implements FileHandler {
	//
	public FileDeleteHandler() {
		// 
		
	}
	
	@Override
	public ResponseMessage handle(RequestMessage request) {
		// 
		FileStore fileStore = getFileStore(); 
		String fileName = request.getValue(); 
		
		fileStore.deleteFile(fileName); 
		
		return new ResponseMessage(request.getServiceName(), String.valueOf(fileName)); 
	}

	public FileStore getFileStore() {
		// 
		return FileStore.newInstance(); 
	}
}