package normalj;
import java.util.*;

public class ArrayListEx {
	
	
	public static void main(String []args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("d");
		list.add("e");
		list.add(3,"f");
		System.out.println("list is"+list);
		
		String[] aStrings= {"p","q","r"};
		list.addAll(Arrays.asList(aStrings));
		
		System.out.println(list);
		
		String element=list.get(2);
		System.out.println("element at 2 index"+element);
		
		list.set(0, "q");
		
		System.out.println("list"+list);
		
		
		list.remove(1);
		System.out.println("list"+list);
		
		list.remove("q");
		System.out.println("list"+list);
		list.forEach(System.out::println);
		
		list.clear();
		System.out.println("list"+list);
		
		
	}

}
