package normalj;

import java.util.TreeSet;

public class TreeSetEx {
	
	
	public static void main(String[] args) {
		
		TreeSet<String> tset=new TreeSet<>();
		tset.add("t3");
		tset.add("t2");
		tset.add("t4");
		tset.add("t5");
		System.out.println(tset);
		
		System.out.println(tset.contains("t3"));
		System.out.println(tset.headSet("t3"));
		System.out.println(tset.subSet("t3", "t5"));
		
		
	}

}
