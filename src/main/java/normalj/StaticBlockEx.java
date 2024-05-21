package normalj;

public class StaticBlockEx {
	
	static int x=99;
	
	
	static {
		System.out.println("This is a static block executed on class load");
		x=200;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String []args) {
		System.out.println("starting static block"+x);
	}
	
	

}
