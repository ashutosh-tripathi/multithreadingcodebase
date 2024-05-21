package normalj;

public class EnumEx {
	
	
	public static enum status{
		Run,Stop, Pending, waiting
	}
  public static void main(String []args) {
	  System.out.println(status.Run);
	  System.out.println(status.Stop.ordinal());
	  System.out.println(status.valueOf("Pending"));
	  
	  status p=status.waiting;
	  System.out.println(p);
	  System.out.println(p.ordinal());
  }
}
