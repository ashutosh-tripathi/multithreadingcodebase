package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinCaller {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int[] a=new int[100000000];
		for(int i=1;i<100000000;i++)
		{
			a[i]=i;
		}
		long startTime=System.currentTimeMillis();
		double sum=sequentialSum(a);
		long endTime=System.currentTimeMillis();
		
		
		System.out.println("Output of sequential sum is"+sum+"and it took "+(endTime-startTime)+" ms");
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("available processor"+availableProcessors);
		
		
		startTime=System.currentTimeMillis();
		RecursiveActionSum ras= new RecursiveActionSum(0, a.length, a);
		ForkJoinPool fjp=new ForkJoinPool(16);
		fjp.invoke(ras);
		
		double  rassum=ras.sum;
		 endTime=System.currentTimeMillis();
		System.out.println("Output of parallel sum is"+rassum+"and it took "+(endTime-startTime)+" ms");
		
		startTime=System.currentTimeMillis();
		RecursiveTaskSum rts= new RecursiveTaskSum(0, a.length, a);
	
		double  rtssum=fjp.invoke(rts);
		
		
		 endTime=System.currentTimeMillis();
		System.out.println("Output of parallel sum is"+rtssum+"and it took "+(endTime-startTime)+" ms");
		
		
		
		
		
		
		
		/*int[] a= {1,2,3,4,5,6,7,8,9};
		ForkJoinRecursiveSum fj1=new ForkJoinRecursiveSum(a, 0, a.length);
		
		ForkJoinPool fjp=new ForkJoinPool();
int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("available processor"+availableProcessors);
        // Set the desired parallelism level
        int maxThreads = availableProcessors; // Set it to the number of available processors or your desired value
        
        // Create a ForkJoinPool with the desired parallelism level
        ForkJoinPool forkJoinPool = new ForkJoinPool(maxThreads);

		fjp.invoke(fj1);
		fjp.awaitTermination(2, TimeUnit.SECONDS);
		double sum=fj1.getSum();
		System.out.println(sum);*/
	}
	
	public static double sequentialSum(int[] a) {
		
		double sum=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				sum+=1/(double)a[i];
			}
		}
		
		return sum;
		
		
		
		
	}

}
