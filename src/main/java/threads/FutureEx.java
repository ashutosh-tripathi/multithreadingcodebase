package threads;

import java.util.concurrent.*;

	public class FutureEx {
	    public static void main(String[] args) throws InterruptedException, ExecutionException {
	        ExecutorService executor = Executors.newSingleThreadExecutor();
	        Future<Integer> future = executor.submit(() -> {
	            // Simulate a time-consuming computation
	            Thread.sleep(2000);
	            return 42;
	        });

	        System.out.println("Task submitted");
	        // Perform other operations while the task is running

	        // Check if the task is done
	        if (!future.isDone()) {
	            System.out.println("Task is not yet completed");
	        }

	        // Retrieve the result of the computation
	        Integer result = future.get();

	        System.out.println("Task completed with result: " + result);

	        executor.shutdown();
	    }
	}



