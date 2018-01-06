package namoosori.oops.thread.java.step03.singleton;

public class StaticSingleReader {
	//
	private static StaticSingleReader singleReader; 
	
	static {
		try {
			singleReader = new StaticSingleReader(); 
		}catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
	}
	
	private StaticSingleReader() {
		// 
	}
	
	public static StaticSingleReader getInstance() {
		// 
		return singleReader; 
	}
}