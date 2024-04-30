package parallel;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionSum extends RecursiveAction {
	
	private static final long serialVersionUID = 1L;
	int low,high;
	double sum;
	int[] a;
	
	
	
	public RecursiveActionSum(int _low,int _high, int[] _a) {
		this.low=_low;
		this.high=_high;
		this.a=_a;
	}
	
	
	
	
	

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
		if(high-low<=100000) {
			for(int i=low;i<high;i++) {
				if(a[i]!=0)
				this.sum+=1/(double)a[i];
			}
		} else {
			int mid=(high+low)/2;
			RecursiveActionSum left=new RecursiveActionSum(low,mid,a);
			RecursiveActionSum right=new RecursiveActionSum(mid,high,a);
			left.fork();
			right.compute();
			left.join();
			this.sum=left.sum+right.sum;
		}
		
	}

}

