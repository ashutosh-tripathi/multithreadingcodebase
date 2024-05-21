package normalj;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<String, Integer> hm=new HashMap<>();
		hm.put("One", 1);
		hm.put("Two", 2);
		hm.put("Three", 3);
		hm.put("Four", 4);
	        System.out.println("map is "+hm);
	        
	       System.out.println("value for key is"+hm.get("Two"));
	       hm.remove("Three");
	       System.out.println("map is "+hm);
	       
	       System.out.println("containsKey"+hm.containsKey("Two"));
	       System.out.println("containsValue"+hm.containsValue(2));
	       for (String key : hm.keySet()) {
	            System.out.println(key);
	        }
	       for (int val : hm.values()) {
	            System.out.println(val);
	        }
	       System.out.println("Key-Value pairs in HashMap:");
	        for (Entry<String, Integer> entry : hm.entrySet()) {
	            System.out.println(entry.getKey() + " = " + entry.getValue());
	        }

	}
	
	
}
