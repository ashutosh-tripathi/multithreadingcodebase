package normalj;

import java.util.Objects;

public class RecordEx {
	
	public static void main(String []args) {
		User u1=new User(20,"Name");
		User u2=new User(20, "Name");
		System.out.println(u1.toString());
		System.out.println(u1.equals(u2));
		
		User1 user1=new User1(20,"Name");
		User1 user2=new User1(20, "Name");
		
		System.out.println(user1.toString());
		System.out.println(user1.equals(user2));
		System.out.println(user1.id);
	}
	
	record User1(int id,String name) {};
	
	
	public static class User{
		public User(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		int id;
		String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(id, name);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return id == other.id && Objects.equals(name, other.name);
		}
		
	}
	
	
	
	
	

}
