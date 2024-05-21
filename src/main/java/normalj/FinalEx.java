package normalj;

public class FinalEx {
	
	
	public static void main(String []args) {
		final int i=200;
//		i=300;
		System.out.println(i);
 	}
	public static class A{
		
		
		
		public final void A(int x) {
			System.out.println(x);
		}
	}
	public static class B extends A{
		public void A(String x) {
			System.out.println("X is"+x);
		}
//		public void A(int x) {
//			System.out.println("X is"+x);
//		}
	} 
	
	
	public static final class C{
		
	}
	//	public static final class D extends C{
	//		
	//	}

}
