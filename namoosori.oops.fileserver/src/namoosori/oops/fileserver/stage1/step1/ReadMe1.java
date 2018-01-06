/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */
package namoosori.oops.fileserver.stage1.step1;

import java.util.ArrayList;
import java.util.List;

public class ReadMe1 {
	//
	public static void main(String[] args) {
		// 
		List<String> guides = getExtension(); 
		
		for(String guide : guides) {
			System.out.println(guide); 
		}
	}
	 
	public static List<String> getExtension() {
		// 
		List<String> guides = new ArrayList<>(); 
		guides.add("Extension 1: simple file read/write in a specified folder."); 
 		
		return guides; 
	}
}