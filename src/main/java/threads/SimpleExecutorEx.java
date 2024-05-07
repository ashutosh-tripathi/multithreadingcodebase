package threads;

import java.util.concurrent.Executor;

public class SimpleExecutorEx
{
	
	
	public static void main(String []args) {
		SimpleExecutor executor = new SimpleExecutor();
		Runnable task = () -> System.out.println("Executing task ...");
		executor.execute(task);
		
	}
	  public static class SimpleExecutor implements Executor{

		@Override
		public void execute(Runnable command) {
	
			new Thread(command).start();
		}
		
	}

}
