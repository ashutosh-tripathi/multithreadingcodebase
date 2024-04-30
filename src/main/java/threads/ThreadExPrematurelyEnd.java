package threads;

import java.math.BigInteger;

public class ThreadExPrematurelyEnd {
	
	
	public static void main(String[] args) {
	    Thread th = new Thread(new BigPow(BigInteger.valueOf(100), BigInteger.valueOf(1000000000)));
	    
	    // Set the thread as daemon after it has started
	    th.setDaemon(true);
	    th.start();

	    
	    // Sleep for some time to allow the thread to execute
	    try {
	        Thread.sleep(1000); // Sleep for 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    // Interrupt the thread after some time
	    th.interrupt();
		
	    if (th.isAlive()) {
	    	System.out.println("thread is living");
	    }
	}
	
	public static class BigPow implements Runnable{

		BigInteger base;
		BigInteger pow;
		
		
		public BigPow(BigInteger base, BigInteger pow) {
			super();
			this.base = base;
			this.pow = pow;
		}



		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("is this daemon thread"+Thread.currentThread().isDaemon());
			BigInteger result=calculateBigPow(base, pow);
			System.out.println("calculated result is"+result);
			
		}
		
		
		
		public BigInteger calculateBigPow(BigInteger base, BigInteger pow) {
			BigInteger result=BigInteger.ONE;
			
			for(BigInteger i=BigInteger.ZERO;i.compareTo(pow)!=0;i=i.add(BigInteger.ONE)) {
				if(Thread.currentThread().isInterrupted())
				{
					return BigInteger.ZERO;
				}
//				System.out.println("multiplying"+base+" for "+i+" time ");
				result=result.multiply(base);
			}
			return result;
			
			
		}
	}

}
