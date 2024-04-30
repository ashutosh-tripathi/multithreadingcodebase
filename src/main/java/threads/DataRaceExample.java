package threads;

public class DataRaceExample {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Metrics metrics=new Metrics(10, 10);
		Thread th1=new Thread(()->{
			while(true) {
			metrics.inc();
			}
		});
		Thread th2=new Thread(()->{
			while(true) {
			metrics.checkForDataRace()
			;}
		});
		th1.start();
		th2.start();
		
		
		
		
	}
	public static class Metrics{
		int x;
		int y;
		
		public Metrics(int a, int b) {
			x=a;y=b;
		}
		public void inc() {
			x++;
			y++;
		}
		public void checkForDataRace() {
			if(y>x) {
				System.out.println("data race is detected");
			}
		}
		
	}

}
