package normalj;

import java.util.ArrayList;


public class GenericsEx {
	
	private static class Box<T>{
		T content;

		public T getContent() {
			return content;
		}

		public void setContent(T content) {
			this.content = content;
		}
		
		
	}
	
	
	
	
	 public static void main(String[] args) {
		ArrayList arrayList=new ArrayList<>();
		arrayList.add("string");
		arrayList.add(1);
		System.out.println("arraylist"+arrayList);
		System.out.println(arrayList.get(0));
		int x=(int) arrayList.get(1);
		
		
		Box<Integer> intBox=new Box();
		Box <String> stringBox=new Box<String>();
		
		intBox.setContent(100);
		stringBox.setContent("stringBox");
		System.out.println("int box content"+intBox.getContent());
		System.out.println("string box content"+stringBox.getContent());
		
	}
	 
	 
	 

}
