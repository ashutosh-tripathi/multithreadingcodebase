package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelForLoop {

    public static void main(String[] args) {
        parallelFor(0, 10, i -> {
            System.out.println("Iteration: " + i);
        });
    }

    public static void parallelFor(int startInclusive, int endExclusive, LoopBody body) {
        
        int numThreads = Runtime.getRuntime().availableProcessors();
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int iterationsPerThread = (endExclusive - startInclusive) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            executor.submit(() -> {
                int startIndex = startInclusive + threadIndex * iterationsPerThread;
                int endIndex = (threadIndex == numThreads - 1) ? endExclusive : (startIndex + iterationsPerThread);
                for (int j = startIndex; j < endIndex; j++) {
                    body.execute(j);
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Functional interface for loop body
    interface LoopBody {
        void execute(int index);
    }
}
