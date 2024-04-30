package parallel;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskSum  extends RecursiveTask<Double>{

	private static final long serialVersionUID = 1L;
	int low,high;
	int[] a;
	
	
	
	public RecursiveTaskSum(int _low,int _high, int[] _a) {
		this.low=_low;
		this.high=_high;
		this.a=_a;
	}
	
	@Override
	protected Double compute() {
		double sum=0;
		if(high-low<=100000) {
			for(int i=low;i<high;i++) {
				if(a[i]!=0)
				sum+=1/(double)a[i];
			}
			return sum;
		} else {
			int mid=(high+low)/2;
			RecursiveTaskSum left=new RecursiveTaskSum(low,mid,a);
			RecursiveTaskSum right=new RecursiveTaskSum(mid,high,a);
			left.fork();
			double rightresult=right.compute();
			double leftresult=left.join();
			return leftresult+rightresult;
		}
	}

}
