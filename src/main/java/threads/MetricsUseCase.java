package threads;


import java.util.Random;

public class MetricsUseCase {

	
	
	public static void main(String[] args) {
		Metrics metrics=new Metrics();
		Adder th1=new Adder(metrics);
		Adder th2=new Adder(metrics);
		Printer th3=new Printer(metrics);
		
		
		th1.start();
		th2.start();
		th3.start();
		
		
	}
	
	
	
	public static class Printer extends Thread{
		
		Metrics metrics;
		public Printer(Metrics _metrics) {
			metrics=_metrics;
		}
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("average is "+metrics.getAverage());
			}
			
			
		}
		
		
	}
	
	
	
	
	public static class Adder extends Thread{
		
		Metrics metrics;
		Random random=new Random();
		public Adder(Metrics _metrics) {
			metrics=_metrics;
		}
		
		@Override
		public  void  run(){
			while(true) {
			long start=System.currentTimeMillis();
			
			try {
				Thread.sleep(random.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			long end=System.currentTimeMillis();
			
			metrics.addSample(end-start);
			}
			
		}
	}
	
	public static class Metrics{
		
		long count;
		double average=0;
		
		public synchronized void addSample(long sample) {
			double pretotal=average*count;
			count++;
			double total=pretotal+sample;
			average=total/count;
		}
		
		
		
		public double getAverage() {
			return average;
		}
		
	}
}
