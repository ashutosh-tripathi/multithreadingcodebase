package threads;

public class DaemonThread {
	public static void main(String[] args) {
		// Create a daemon thread
		Thread daemonThread = new Thread(new DaemonTask());
		daemonThread.setDaemon(true); // Set the thread as daemon
		daemonThread.start();
		
		// Main thread
		System.out.println("Main thread started.");
		try {
			Thread.sleep(1000); // Sleep for 3 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread exiting.");
	}

	static class DaemonTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println("Daemon thread is running...");
				try {
					Thread.sleep(1000); // Sleep for 1 second
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
