package normalj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientEx {
	
	
	public static class User implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private String username;
		private transient String password;
//		private String password;
		
		public User(String _username, String _password)
		{
			username=_username;
			password=_password;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + "]";
		}
	}
	
	
	
	
	
	public static void main(String []args) throws FileNotFoundException, IOException, ClassNotFoundException {
		User user=new User("Ashu", "Ashu");
		try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("user.ser"))){
			objectOutputStream.writeObject(user);
		}
		User deserializedUser=null;
		
		try(ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream("user.ser"))){
			deserializedUser=(User)objectInputStream.readObject();
		}
		
		System.out.println(deserializedUser.toString());
	}

}
