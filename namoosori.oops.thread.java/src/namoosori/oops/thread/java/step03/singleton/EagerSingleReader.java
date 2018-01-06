package namoosori.oops.thread.java.step03.singleton;

public class EagerSingleReader {
	//
	private static final EagerSingleReader singleReader = new EagerSingleReader(); 
	
	private EagerSingleReader() {
		// 
	}
	
	public static EagerSingleReader getInstance() {
		// 
		return singleReader; 
	}
}