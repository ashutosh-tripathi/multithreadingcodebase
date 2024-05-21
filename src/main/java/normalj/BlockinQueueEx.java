package normalj;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockinQueueEx {

	
	
	public static void main(String[] args) {
		int size=2;
		BlockingQueue< String> queue=new ArrayBlockingQueue(size);
		
		Thread th1=new Thread(()->{
			try {
				Thread.sleep(100);
				queue.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		th1.start();
		
		try {
			queue.add("t1");
			queue.put("t2");
			System.out.println("queue is"+queue);
			th1.join();
			queue.add("t3");
			System.out.println("queue is"+queue);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
