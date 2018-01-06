package namoosori.oops.thread.java.step04.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageBook {
	//
	private List<String> contents; 
	
	public MessageBook() {
		//
		this.contents = new ArrayList<>(); 
		init(); 
	}
	
	public Iterator<String> iterator() {
		// 
		return contents.iterator(); 
	}
	
	private void init() {
		//
		contents.add("Tears In Heaven"); 
		contents.add("Would you know my name"); 
		contents.add("If I saw you in heaven?"); 
		contents.add("Would it be the same"); 
		contents.add("If I saw you in heaven?"); 

		contents.add("I must be strong"); 
		contents.add("And carry on"); 
		contents.add("Cause I know I don't belong"); 
		contents.add("Here in heaven"); 

		contents.add("Would you hold my hand"); 
		contents.add("If I saw you in heaven?"); 
		contents.add("Would you help me stand"); 
		contents.add("If I saw you in heaven?"); 

		contents.add("I'll find my way"); 
		contents.add("Through night and day"); 
		contents.add("'Cause I know I just can't stay"); 
		contents.add("Here in heaven"); 

		contents.add("Time can bring you down"); 
		contents.add("Time can bend your knees"); 
		contents.add("Time can break your heart"); 
		contents.add("Have you begging please, begging please"); 

		contents.add("Beyond the door"); 
		contents.add("There's peace I'm sure"); 
		contents.add("And I know there'll be no more"); 
		contents.add("Tears in heaven"); 

		contents.add("Would you know my name"); 
		contents.add("If I saw you in heaven?"); 
		contents.add("Would you be the same"); 
		contents.add("If I saw you in heaven?"); 

		contents.add("I must be strong"); 
		contents.add("And carry on"); 
		contents.add("'Cause I know I don't belong"); 
		contents.add("Here in heaven"); 
	}
}
