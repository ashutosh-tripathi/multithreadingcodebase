package normalj;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileEx {
	
//	public static volatile int counter=1000;

//	public static  int counter=1000;
	public static AtomicInteger counter=new AtomicInteger(1000);
	
	public static void main(String []args) throws InterruptedException {
		
		Thread t1=new Thread(()->{
			for(int i=0;i< 100000;i++) {
				counter.incrementAndGet();
			}
		});
		Thread t2=new Thread(()->{
			for(int i=0;i< 100000;i++) {
				counter.decrementAndGet();
			}
		});
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
		System.out.println(counter);
		
	}

}
