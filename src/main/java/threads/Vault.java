package threads;

import java.util.*;
public class Vault {
	public static final int maxpass=9999;

	public static void main(String []args) {
		
		
		
		Random rand=new Random();
		int x=rand.nextInt(maxpass);
		System.out.println("vault key is"+x);
		VaultUnder _vault=new VaultUnder(x);
		
		List<Thread> th=new ArrayList<Thread>();
		th.add(new AscendingHackerThread(_vault));
		th.add(new DescendingHackerThread(_vault));
		th.add(new PoliceThread());
		
		
		for( Thread thn:th) {
			thn.start();
		}
		
	}
	public static class VaultUnder{
		private int pass;

		public VaultUnder(int pass) {
			super();
			this.pass = pass;
		}
		public boolean isCorrectPassword(int _pass) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pass==_pass)
				return true;
			else 
				return false;
		}
	}
	
	public static class HackerThread extends Thread{
	protected VaultUnder vaultunder;
	
	
	public HackerThread(VaultUnder _vaultUnder) {
		this.vaultunder=_vaultUnder;
		this.setName(this.getClass().getSimpleName());
		this.setPriority(MAX_PRIORITY);
	}
	@Override
	public void start(){
		System.out.println("starting thread"+this.getName());
		super.start();
	}
}	
	
	public static class AscendingHackerThread extends HackerThread{

		public AscendingHackerThread(VaultUnder _vaultUnder) {
			super(_vaultUnder);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			for (int i=0;i<maxpass;i++) {
				if(vaultunder.isCorrectPassword(i)) {
					System.out.println("ascending thread guessed password is correct");
					System.exit(0);
				}
			}
			
		}
	}

	public static class DescendingHackerThread extends HackerThread{

		public DescendingHackerThread(VaultUnder _vaultUnder) {
			super(_vaultUnder);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			for (int i=maxpass;i>0;i--) {
				if(vaultunder.isCorrectPassword(i)) {
					System.out.println("descending thread guessed password is correct");
					System.exit(0);
				}
			}
			
		}
	}
	
	public static class PoliceThread extends Thread{
		@Override
		public void run() {
			
			for(int i=0;i< 10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Police arriving in "+i+" seconds");
			}
			System.out.println("Game over for hackers");
			System.exit(0);
			
			
			
		}
	}

}
