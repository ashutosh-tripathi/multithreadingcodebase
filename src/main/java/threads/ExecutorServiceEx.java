package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceEx {

	public static void main(String []args) throws InterruptedException {
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		try {
		checkStates(executorService, "Before Starting ");
		executorService.execute(diceRoll());
		executorService.execute(diceRoll());
		executorService.execute(diceRoll());
		checkStates(executorService, "After Starting ");
		}finally {
			checkStates(executorService, "Before shutdown() ");
			executorService.shutdown();
			checkStates(executorService, "After shutdown() ");
//			checkStates(executorService, "Before shutdown() now");
//			executorService.shutdownNow();
//			checkStates(executorService, "After shutdown() now");
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		}
	}
	
	private static void checkStates(ExecutorService executorService,String msg) {
		System.out.printf("%-40s %-5s %-5s%n",msg, executorService.isShutdown(), executorService.isTerminated());
	}
	
	public static final Runnable diceRoll() {
		return ()->{
			int diceVal=ThreadLocalRandom.current().nextInt(1,7);
			System.out.println(Thread.currentThread().getName()+" rolled dice "+diceVal);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
	}
	
	
	
	
	
}
