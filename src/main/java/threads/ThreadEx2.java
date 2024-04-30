package threads;

public class ThreadEx2 {
	
	
	public static void main(String[] args) {
		
		
		Thread t1=new NewThread();
				
				
		t1.setName("New Thread");
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("before starting thread"+Thread.currentThread().getName());
		t1.start();
		
		System.out.println("after starting thread"+Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			System.out.println("In threaad"+Thread.currentThread().getName()+"with value"+i);
		}
		
	}

}

class NewThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("In threaad"+Thread.currentThread().getName()+"with value"+i);
			
		}
	}
}
