package threads;

public class ThreadEx4 {

   public static void main(String []args) {
	  MyThread th1=new MyThread();
	  th1.start();
	   System.out.println("main thread");
   }
  static  class MyThread extends Thread{
		 
		 @Override
		 public void run() {
			 System.out.println("thread is created here");
		 }

  }
	 
 }