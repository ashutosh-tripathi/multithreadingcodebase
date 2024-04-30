package threads;

public class ThreadEx5Interrupted {

	public static void main(String[] args) {
		
		
		Thread th1=new Thread(new BlockingThread());
		th1.start();
		System.out.println("started Blocking Thread");
		th1.interrupt();
	}
	
	
	public static class BlockingThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("stopping main execution");
				e.printStackTrace();
			}
			
		}
		
			
		
		
	}
	
	
}
