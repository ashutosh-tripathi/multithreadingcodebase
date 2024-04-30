package threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockEx {
	
	public static  int highestPrice=10000;
	public static void main(String[] args) throws InterruptedException {
		InventoryDatabase inventoryDatabase=new InventoryDatabase();
		Random random=new Random();
	 for(int i=0;i< 10000;i++) {
		 inventoryDatabase.addItem(random.nextInt(highestPrice));
	 }
	 Thread writerThread=new Thread(()->{
		while(true) {
			inventoryDatabase.addItem(random.nextInt(highestPrice));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	 });
	 writerThread.setDaemon(true);
	 writerThread.start();
	 List<Thread> threads=new ArrayList<Thread>();
	 for(int i=0;i<10;i++) {
		 Thread readerThread=new Thread(()->{
			 for(int j=0;j<10000;j++) {
				 int ubp=random.nextInt(highestPrice);
				 inventoryDatabase.getNumberOfItemsInPriceRange(0, ubp);
				 
			 }
			 
		 });
		 readerThread.setDaemon(true);;
		 threads.add(readerThread);
		 
	 }
	 long startReadingTime = System.currentTimeMillis();
	 for (Thread reader : threads) {
	 reader.start();
	 }
	 for (Thread reader : threads) {
	 reader.join();
	 }
	 Long endReadingTime = System.currentTimeMillis();
	 Thread.sleep(100);
	 System.out.println(String. format ("Reading took %d ms", endReadingTime - startReadingTime));
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}
	
	
	
	
	
	private static class InventoryDatabase{
		Map <Integer,Integer> productCountMap=new HashMap<>();
		Lock lock=new ReentrantLock();
		ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
		
		private int getNumberOfItemsInPriceRange(int lowerbound,int upperbound) {
			int count=0;
			readWriteLock.readLock().lock();
//			lock.lock();
				try {
			for(int keys:productCountMap.keySet()) {
				if(keys>=lowerbound&& keys<=upperbound) {
					count+=productCountMap.get(keys);
				}
			}
			}finally {
				readWriteLock.readLock().unlock();
//				lock.unlock();
			}
			
			return count;	
			
		}
		private void addItem(int productId) {
			readWriteLock.writeLock().lock();
//			lock.lock();
			try {
			if(productCountMap.get(productId)==null || productCountMap.get(productId)==0) {
				productCountMap.put(productId, 1);
			} else {
				productCountMap.put(productId, productCountMap.get(productId)+1);
			}
			}finally {
			readWriteLock.writeLock().unlock();
//			lock.unlock();
			}
			
		}
		
	}

}
