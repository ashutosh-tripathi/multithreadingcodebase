package threads;

import java.util.concurrent.atomic.AtomicInteger;

import threads.Vault.DescendingHackerThread;

public class AtomicIntEx {
	
	public static void main(String[] args) throws InterruptedException {
		InventoryThread inventoryThread=new InventoryThread();
		Thread th1=new Thread(new AscendingThread(inventoryThread));
		Thread th2=new Thread(new DescendingHackerThread(inventoryThread));
		th1.start();
		th2.start();
		
		
		th1.join();
		th2.join();
		System.out.println("final value is"+inventoryThread.getItem());
		
	}
	private static class AscendingThread extends Thread{
       InventoryThread inventoryThread;
		
		public AscendingThread(InventoryThread _inInventoryThread) {
			// TODO Auto-generated constructor stub
			inventoryThread=_inInventoryThread;
		}
		
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				inventoryThread.increment();
			}
			
		}
		
	}
	private static class DescendingHackerThread extends Thread{
		InventoryThread inventoryThread;
		
		public DescendingHackerThread(InventoryThread _inInventoryThread) {
			// TODO Auto-generated constructor stub
			inventoryThread=_inInventoryThread;
		}
		
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				inventoryThread.decrement();
			}
			
		}
		
		
	}
	
	private static class InventoryThread{
		AtomicInteger atomicInteger=new AtomicInteger(5);
		private void increment(){
			atomicInteger.incrementAndGet();
			System.out.println("current value is"+atomicInteger.get());
		}
		private void decrement() {
			atomicInteger.decrementAndGet();
		}
		private int getItem() {
			return atomicInteger.get();
		}
	}
	
	

}
