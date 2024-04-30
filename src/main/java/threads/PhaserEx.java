package threads;
import java.util.concurrent.Phaser;

public class PhaserEx {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Initial party count (main thread)

        // Start three parallel tasks in separate threads
        Thread task1 = new Thread(new Worker("Task 1", phaser));
        Thread task2 = new Thread(new Worker("Task 2", phaser));
        Thread task3 = new Thread(new Worker("Task 3", phaser));

        task1.start();
        task2.start();
        task3.start();

        // Main thread arrives at the barrier to synchronize with worker threads
        phaser.arriveAndAwaitAdvance();
        System.out.println("All threads completed phase 1. Main thread continuing...");

        // Main thread arrives at the barrier for phase 2
        phaser.arriveAndAwaitAdvance();
        System.out.println("All threads completed phase 2. Main thread continuing...");

        // Main thread arrives at the barrier for phase 3
        phaser.arriveAndAwaitAdvance();
        System.out.println("All threads completed phase 3. Main thread continuing...");

        // Shutdown the Phaser
        phaser.arriveAndDeregister();
    }
}

class Worker implements Runnable {
    private final String taskName;
    private final Phaser phaser;

    public Worker(String taskName, Phaser phaser) {
        this.taskName = taskName;
        this.phaser = phaser;
        phaser.register(); // Registering thread with the Phaser
    }

    @Override
    public void run() {
        // Perform tasks for each phase
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " performing phase " + i);
            // Simulate work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Synchronize at the barrier
            phaser.arriveAndAwaitAdvance();
        }
        // Deregistering thread from the Phaser
        phaser.arriveAndDeregister();
    }
}
