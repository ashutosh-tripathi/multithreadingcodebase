package normalj;

import java.util.*;
public class DequeueEx {

	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		deque.addFirst("e1");
        deque.addLast("e2");
        deque.offerFirst("e3");
        deque.offerLast("e4");
        System.out.println("Deque" + deque);
        System.out.println("first"+deque.getFirst());
        System.out.println("last"+deque.getLast());
        
        deque.removeFirst();
        System.out.println(deque);
	}
}
