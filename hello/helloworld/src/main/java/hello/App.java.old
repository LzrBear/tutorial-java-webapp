package hello;

import csvXtract.csvXtractRunnable;

/**
 * Hello world!
 *
 */
public class App {
    private static csvXtractRunnable csvXtractThread = new csvXtractRunnable();
    private static Thread thread; // = new Thread(csvXtractThread);

    public static void main(String[] args) {
        System.out.println("CSVXtract Status: " + getStatus());

        System.out.println("Starting CSVXtract");
        start();
        start();
        start();
        start();
        start();
        start();
        start();
        start();

        try {
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());

            Thread.sleep(10L * 1000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping CSVXtract");
        stop();

        System.out.println("Starting CSVXtract");
        start();

        // try {
        //     // System.out.println("CSVXtract Status: " + getStatus());
        //     // Thread.sleep(1);
        //     // System.out.println("CSVXtract Status: " + getStatus());
        //     // Thread.sleep(10);
        //     // System.out.println("CSVXtract Status: " + getStatus());

        //     //System.out.println("Wait 15 sec");

        //     //Thread.sleep(15L * 1000L);

        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Starting CSVXtract");
        start();
    }

    public static String getName() {
        // return "Koala";
        return System.getProperty("user.dir");
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
