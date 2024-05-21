package normalj;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetEx {
	public static void main(String[] args) {
		LinkedHashSet<String> temp=new LinkedHashSet();
		temp.add("t1");
		temp.add("t2");
		temp.add("t3");
		System.out.println(temp);
		temp.add("t1");
		System.out.println(temp);
		
		
		System.out.println("size"+temp.size());
		
		
		System.out.println("contains t2"+temp.contains("t2"));
		temp.remove("t2");
		System.out.println("after remove"+temp);
		for(String elem: temp) {
			System.out.println(elem);
		}
		
		
		temp.forEach(System.out::println);
	}

}
