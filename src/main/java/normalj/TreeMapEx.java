package normalj;

import java.util.TreeMap;

public class TreeMapEx {

	public static void main(String[] args) {
		TreeMap<String,Integer> tm=new TreeMap<>();
		tm.put("e3", 3);
		tm.put("e2", 2);
		tm.put("e1", 1);
		tm.put("5", 5);
		System.out.println(tm);
		
		
		System.out.println(tm.get("e3"));
		
		
		tm.remove("e1");
		System.out.println(tm);
		
		
		String fk=tm.firstKey();
		String lk=tm.lastKey();
		System.out.println(fk+" "+lk);
		
		
		System.out.println("higher"+tm.higherKey("e2"));
		
	}
}
