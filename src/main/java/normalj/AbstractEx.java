package normalj;

public class AbstractEx {
 
	public static void main(String []args) {
		
		
		Animal dog=new Dog();
		dog.makeSound();
		dog.sleep(5);
		Animal cat=new Cat();
		cat.makeSound();
		cat.sleep(10);
		
	}
	
	
	
	
	
	
	
	public static abstract class Animal{
		int x;
		public abstract void makeSound();
		public void sleep(int _x) {
			System.out.println("Animal is sleeping for"+_x);
		}
	}
	public static class Dog extends Animal{

		@Override
		public void makeSound() {
			// TODO Auto-generated method stub
			System.out.println("Make bhau sound");
		}
		
	}
	public static class Cat extends Animal{

		@Override
		public void makeSound() {
			// TODO Auto-generated method stub
			System.out.println("Make meow sound");
			
		}
		
	}
}
