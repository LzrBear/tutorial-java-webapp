package CSVXtract;

public class csvXtractExecutor {

    private static csvXtractRunnable csvXtractThread = new csvXtractRunnable();
    private static Thread thread; // = new Thread(csvXtractThread);

    public static String getLogPath() {
        //return "Koala";
        return csvXtractThread.getLogPath();
    }

    public static String getStatus() {
        String status = "Unknown";

        if (thread != null && thread.isAlive()) {
            status = "Running";
        } else {
            status = "Stopped";
        }

        return status;
    }

    public static String getLogs() {
        return csvXtractThread.getLogs();
    }

    public static void stop() {
        // Tell the task to stop
        csvXtractThread.stop();

        // Wait for it to do so
        try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    public static void start() {
        System.out.println("Checking if thread is alive");
        if (thread == null || !thread.isAlive()){ //i think calling isAlive is threadsafe - ref. https://stackoverflow.com/questions/9346731/is-java-lang-thread-itself-a-thread-safe-class
            System.out.println("thread not alive, starting new thread");
            thread = new Thread(csvXtractThread);
            thread.start();
        }
        System.out.println("thread alive, do nothing");
    }
}
