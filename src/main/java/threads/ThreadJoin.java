package threads;

import java.math.BigInteger;
import java.util.*;

public class ThreadJoin {

	public static void main(String []args) {
		
	int[] a= {10,25,2556,2798,500,555,666,90000};
	List<FactorialThread> threads=new ArrayList<>();
	
	for(int a1:a) {
		FactorialThread th1=new FactorialThread(a1);
		threads.add(th1);
	}
	
	for(Thread th:threads) {
		th.start();
	}
	
	for(Thread th:threads) {
		try {
			th.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	for(FactorialThread th:threads) {
		if(th.isFinished) {
			System.out.println("Thread with id "+th.getId()+" with num "+th.num+" is "+th.result);
		} else {
			System.out.println("The calculation of thread "+th.getId()+" with num "+th.num+" is in progress");
		}
	}
		
		
		
		
	}
	
	public static class FactorialThread extends Thread{
		
		BigInteger result=BigInteger.ONE;
		boolean isFinished=false;
		public BigInteger getResult() {
			return result;
		}

		public void setResult(BigInteger result) {
			this.result = result;
		}

		public boolean isFinished() {
			return isFinished;
		}

		public void setFinished(boolean isFinished) {
			this.isFinished = isFinished;
		}

		int num;
		
		public FactorialThread(int _num) {
			this.num=_num;
		}
		
		@Override 
		public void run() {
			result= calculateFactorial();
			isFinished=true;
			if(num==10000) {
				try {
					Thread.sleep(50000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public BigInteger calculateFactorial() {
			
			BigInteger temp=BigInteger.ONE;
			for(int i=0;i<num;i++) {
				temp=temp.multiply(BigInteger.valueOf(num));
			}
			return temp;
		}
	}
}
