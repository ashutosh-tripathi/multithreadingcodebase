package threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsEx {
    public static void main(String[] args) throws InterruptedException {
        var begin = Instant.now();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//        ExecutorService executor=Executors.newFixedThreadPool(1_000);
//        ExecutorService executor=Executors.newCachedThreadPool();
        try  {
            IntStream.range(0, 100_00_000).forEach(i -> executor.submit(() -> {
                //                    Thread.sleep(10); // Convert Duration to milliseconds
				System.out.println("hello"+i);
                return i;
            }));
        } 
        finally {
			executor.shutdown();
		}

        var end = Instant.now();
        System.out.println(Duration.between(begin, end));
    }
}
