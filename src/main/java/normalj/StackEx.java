package normalj;

import java.util.Stack;

public class StackEx {
	
	
	public static void main(String[] args) {
		Stack<String> stack=new Stack();
		stack.push("E1");
		stack.push("E2");
		stack.push("E3");
		stack.push("E4");
		System.out.println(stack);
		System.out.println("pop"+stack.pop());
		System.out.println("peek"+stack.peek());
		
		System.out.println(stack);
		System.out.println("ind"+stack.search("E1"));
		
		
	}

}
