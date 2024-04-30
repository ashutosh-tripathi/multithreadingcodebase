package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		
		
		for(int i=0;i<5;i++) {
			Thread thread=new Thread(()->{
				while(true)
				counter.increment();
			});
			thread.start();
		}
		for(int i=0;i<100;i++) {
			Thread.sleep(1000);
			System.out.println("current counter value"+counter.getCount());
		}
		
		
	}
	
	
	
	public static class Counter{
		static int count=0;
		
		final Lock lock=new ReentrantLock();
		
		public void increment() {
			if (lock.tryLock()) {
	            try {
	                count++;
	                System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
	            } finally {
	                lock.unlock();
	            }
	        } else {
//	            System.out.println(Thread.currentThread().getName() + " couldn't acquire lock to increment");
	        }
		}
		public int getCount() {
			lock.lock();
	        try {
	            return count;
	        } finally {
	            lock.unlock();
	        }
		}
		
	}

}
