package threads;

public class ThreadEx3 {
	
	
	public static void main(String []args) {
		
		Thread th=new Thread(()->{
			for(int i=0;i<100;i++)
			System.out.println("In thread lamba");
		});
		
		
		System.out.println(th.getName()+" "+th.getPriority());
		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<100;i++	)
				System.out.println("In normal runnable thread");
			}
			
		});
		
		
		System.out.println(th2.getName()+" "+th2.getPriority());
		
		th.start();
		th2.start();
		th2.setPriority(10);
		System.out.println("main method ends here");
	}
	
	

}
