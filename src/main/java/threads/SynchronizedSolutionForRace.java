package threads;

public class SynchronizedSolutionForRace {

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
		synchronized void increment() {
			number++;
		}
		synchronized void decrementor() {
			number--;
		}
		
		public int getNum() {
			return number;
		}
		
	}
}
