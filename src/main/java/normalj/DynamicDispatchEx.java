package normalj;

public class DynamicDispatchEx {
	
	public class Animal{
		public void bark() {
			System.out.println("This is animal bark");
		}
	}
	public  class Dog extends Animal{
		public void bark() {
			System.out.println("This is dog bark");
		}
	}
	public  class Cat extends Animal{
		public void bark() {
			System.out.println("This is cat bark");
		}
	}
	
	
	public static void main(String []args) {
		DynamicDispatchEx ex=new DynamicDispatchEx();
		Animal  a1=ex.new  Dog();
		Animal a2=ex.new Cat();
		a1.bark();
		a2.bark();
	}

}
