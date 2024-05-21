package normalj;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListEx {
	
	
	
	public static void main(String[] args) {
		
		LinkedList<String> temp1=new LinkedList<>();
		temp1.add("S1");
		temp1.addFirst("S2");
		temp1.addLast("S3");
		System.out.println("temp1"+temp1);
		Collections.sort(temp1);

		System.out.println("temp1"+temp1);
		temp1.add(2, "S4");
		System.out.println("temp1"+temp1);
		temp1.remove();
		System.out.println("temp1"+temp1);
		temp1.removeFirst();
		System.out.println("temp1"+temp1);
		temp1.removeLast();
		System.out.println("temp1"+temp1);
		temp1.add("S2");
		System.out.println("temp1"+temp1);
		   String firstElement = temp1.getFirst();
	        String lastElement = temp1.getLast();
	        System.out.println("First Element: " + firstElement);
	        System.out.println("Last Element: " + lastElement);
		
		
		temp1.forEach(System.out::println);
		for(String ele:temp1) {
			System.out.println("ele"+ele);
		}
		
		
		
		
	}

}
