package normalj;

import java.util.LinkedList;
import java.util.Queue;


public class QueueEx {

	
	
	public static void main(String[] args) {
		Queue<String> q=new LinkedList<>();
		
		q.add("e1");
		q.add("e2");
		q.add("e3");
		System.out.println(" q is "+q);
		System.out.println("head"+q.element());
		
		System.out.println("peek"+q.peek());
		
		System.out.println("remove"+q.remove());
		
		System.out.println(" q is "+q);
		
		
		
	}
}
