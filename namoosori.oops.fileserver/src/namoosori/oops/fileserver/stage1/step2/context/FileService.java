package namoosori.oops.fileserver.stage1.step2.context;

import java.io.File;
import java.util.List;

public interface FileService {
	//
	public String store(File file); 
	public String delete(String fileName); 
	public File find(String fileName); 
	public List<String> listFiles(); 
}