package threads;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
	
	
	
	public static void main(String[] args) throws InterruptedException {
//		CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new BarrierAction1());
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarrierAction());
		Thread th1=new Thread(new WorkerThread(cyclicBarrier, "thread1"));
		Thread th2=new Thread(new WorkerThread(cyclicBarrier, "thread2"));
		Thread th3=new Thread(new WorkerThread(cyclicBarrier, "thread3"));
		th1.start();
		th2.start();
		th3.start();
//		cyclicBarrier.wait();
		System.out.println("new here");
	}
    public static class WorkerThread implements Runnable{
    	CyclicBarrier cyclicBarrier;
    	String name;
    	
    	
    	
    	public WorkerThread(CyclicBarrier _cyclicBarrier, String _threadname) {
    		cyclicBarrier=_cyclicBarrier;
    		name=_threadname;
    	}
    	@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Goinng to initialize task with name"+name);
			Random random=new Random();
			int waitime=random.nextInt(100000);
			System.out.println("Thread "+name+" will wait for "+waitime+" ms");
			try {
				Thread.sleep(waitime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Timer finished for"+name);
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	
    	
    	
    	
    }
    
    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            // Barrier action to be executed after all threads reach the barrier
            System.out.println("All threads reached the barrier. Barrier action executed. Resetting barrier.");
        }
    }

}
