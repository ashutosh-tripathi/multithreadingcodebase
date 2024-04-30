package parallel;

import java.util.stream.IntStream;

public class ParallelStreams {

	
	public static void main(String[] args) {
		int[] a=new int[100000000];
		for(int i=1;i<100000000;i++)
		{
			a[i]=i;
		}
		long startTime=System.currentTimeMillis();
		double sum=sequentialModSum(a);
		long endTime=System.currentTimeMillis();
		
		
		System.out.println("Output of sequential sum is"+sum+"and it took "+(endTime-startTime)+" ms");
		 startTime=System.currentTimeMillis();
		 double sum2=IntStream.range(0,a.length).filter(i->a[i]!=0 && a[i]%2==0).mapToDouble(i -> 1/(double)a[i]).sum();
		 endTime=System.currentTimeMillis();
		 
		 System.out.println("Output of stream sum is"+sum2+"and it took "+(endTime-startTime)+" ms");
		 
		 startTime=System.currentTimeMillis();
		 double sum3=IntStream.range(0,a.length).parallel().filter(i->a[i]!=0 && a[i]%2==0).mapToDouble(i -> 1/(double)a[i]).sum();
		 endTime=System.currentTimeMillis();
		 
		 System.out.println("Output of stream sum is"+sum3+"and it took "+(endTime-startTime)+" ms");
		
		
		
		
	}
	
	
public static double sequentialModSum(int[] a) {
		
		double sum=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0 && a[i]%2==0) {
				sum+=1/(double)a[i];
			}
		}
		
		return sum;
		
		
		
		
	}
	
	
}
