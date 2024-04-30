package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.event.TreeWillExpandListener;

public class CountDownLatchEx {
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch countDownLatch=new CountDownLatch(3);
		
		InitializationTask t1=new InitializationTask(countDownLatch,"Task1");
		InitializationTask t2=new InitializationTask(countDownLatch,"Task2");
		InitializationTask t3=new InitializationTask(countDownLatch,"Task3");
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		Thread thread3=new Thread(t3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("going to wait for all threads to complete");
		countDownLatch.await();
		System.out.println("all threads finished");
		
		
	}
	
	
	
	
	
	public static class InitializationTask implements Runnable  {
		CountDownLatch countDownLatch;
		String nameString;
		
		public InitializationTask(CountDownLatch _countDownLatch,String _name) {
			countDownLatch=_countDownLatch;
			nameString=_name;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Goinng to initialize task with name"+nameString);
			Random random=new Random();
			int waitime=random.nextInt(1000000);
			System.out.println("Thread "+nameString+" will wait for "+waitime+" ms");
			try {
				Thread.sleep(waitime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Timer finished for"+nameString);
			countDownLatch.countDown();
		}
		
		
		
		
		
		
	}

}
