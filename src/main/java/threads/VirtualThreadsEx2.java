package threads;

public class VirtualThreadsEx2 {
	
	public static void main(String []args) throws Exception {
		System.out.println(Thread.currentThread().isVirtual());
		Thread.startVirtualThread(()->{
			System.out.println(Thread.currentThread().isVirtual());	
		}).join();
		
		
		Thread.Builder myThreadBuilder=Thread.ofVirtual().name("VT1");
		Runnable runnable =()->{
			System.out.println("Hello");
		};
		Thread start=myThreadBuilder.start(runnable);
		System.out.println(start.getName()+" "+start.getPriority()+" "+start.isVirtual());
		start.setPriority(10);

		System.out.println(start.getName()+" "+start.getPriority()+" "+start.isVirtual());
	}

}
