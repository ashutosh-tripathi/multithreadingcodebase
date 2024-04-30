package threads;

import threads.SynchronizedSolutionForRace.Incrementor;

public class SynchronizedUsingObject {
	public static void main(String[] args) throws InterruptedException {
		Incrementor incrementor=new Incrementor(0);
		
		Thread th1=new Thread(()->{
			for(int i=0;i<5000;i++) {
				incrementor.increment();
			}
		});
		Thread th2=new Thread(()->{
			for(int i=0;i<5000;i++) {
				incrementor.decrementor();
			}
		});
		
		th1.start();
		th2.start();
		
		
		th1.join();
		th2.join();
		
		System.out.println("final value is "+incrementor.number);
		
	}







public static class Incrementor{
	
	int number=0;
	public Incrementor(int num) {
		number=num;
	}
	Object lockObject= new Object();
	//This is required because synchronization works like a lock one lock all format. all threads on an object wont be able to access any synchronized method if any of the object is accessing synchronized
 	synchronized void increment() {
 		synchronized (this.lockObject) {
 			number++;
		}
		
	}
	synchronized void decrementor() {
		synchronized (this.lockObject) {
 			number--;
		}
	}
	
	public int getNum() {
		return number;
	}
	
}

}
