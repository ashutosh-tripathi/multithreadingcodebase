package normalj;

public class AnonymousClassEx {
	
	
	
	public static  interface AnoInt{
		public void method1();
		public void method2();
	}
	public static void main(String []args) {
		AnoInt xAnoInt=new AnoInt() {
			
			@Override
			public void method2() {
				// TODO Auto-generated method stub
				System.out.println("This is implement anonymous class method");
				
			}
			
			@Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("This is implement anonymous class methods2");

				
			}
		};
		xAnoInt.method1();
		xAnoInt.method2();
	}

}
