package threads;

public class ThreadEx1 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++) {
					System.out.println("In threaad"+Thread.currentThread().getName()+"with value"+i);
					
				}
				throw new RuntimeException("An exception occured here");
				
			}
		});
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("An error occured in "+t.getName()+" and exception is");
				e.printStackTrace();
				
			}
		});
		t1.setName("New Thread");
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("before starting thread"+Thread.currentThread().getName());
		t1.start();
		
		System.out.println("after starting thread"+Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			System.out.println("In threaad"+Thread.currentThread().getName()+"with value"+i);
		}
		Thread.sleep(100L);
		
		
	}

}
