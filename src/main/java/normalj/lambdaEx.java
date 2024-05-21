package normalj;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class lambdaEx {
	
	
	@FunctionalInterface
	public interface temp1{
		public void x(int a);
	}
	
	public static void main(String []args) {
		
		
		
		
		temp1 t1=(a)->{
			System.out.println("This is lambda expression"+a);
		};
		t1.x(10);
		
		
		Runnable runnable=()->{
			System.out.println("This is lambda run method");
		};
		Thread thread=new Thread(runnable);
		thread.start();
		Consumer<String> func1= System.out::println;
		 List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		 System.out.println("normal lambda expression");
		 names.forEach(name -> System.out.println(name));
		 System.out.println("method reference");
		 names.forEach(System.out::println);
		 System.out.println("using method reference consumer");
		 names.forEach(func1);
	}
}
