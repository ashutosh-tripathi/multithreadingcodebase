package threads;


public class TempEx {

	public static void main(String[] args) {
		int x=10;
		int y=50;
		System.out.println("Sum x+y is"+sum(x,y));
		
	}
	public static int sum(int a, int b) {
		int sum=0;
		sum=a+b;
		return sum;
	}
	
	
}
