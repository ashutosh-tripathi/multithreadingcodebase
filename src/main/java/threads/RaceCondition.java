package threads;

//result should be 0, which it is not because of race condition

public class RaceCondition {
	
	public static void main(String[] args) throws InterruptedException {
		
		InventoryCounter inventoryCounter=new InventoryCounter(0);
		
		Thread incThread=new Thread(()->{
			
			
				for(int i=0;i<100000;i++) {
					inventoryCounter.incrementInv();
				}
			
		});
		Thread decThread=new Thread(()->{
			
			
			for(int i=0;i<100000;i++) {
				inventoryCounter.decrementInv();
			}
		
	});
		
		incThread.start();
		decThread.start();
		incThread.join();
		decThread.join();
		System.out.println("final val"+inventoryCounter.inventory);
		
	}
	
	
	
	
	
 public static class InventoryCounter {
	 int inventory;
	 public InventoryCounter(int x) {
		 inventory=x;
	 }
	 public void incrementInv() {
		 inventory++;
	 }
	 public void decrementInv() {
		 inventory--;
	 }
 }
	
	

}
