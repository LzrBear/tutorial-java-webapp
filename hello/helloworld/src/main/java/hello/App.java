package hello;

/**
 * Hello world!
 *
 */
public class App 
{
    private static csvXtractRunnable csvXtractThread = new csvXtractRunnable();

    public static void main( String[] args )
    {
        System.out.println("CSVXtract Status: " + getStatus());

        System.out.println("Starting CSVXtract");
        start();

        try {
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(10);

            Thread.sleep(10L * 1000L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CSVXtract Status: " + getStatus());

        System.out.println("Stopping CSVXtract");
        stop();

        System.out.println("CSVXtract Status: " + getStatus());
    }

    public static String getName() {
        //return "Koala";
        return System.getProperty("user.dir");
    }

    public static String getStatus() {
        String status = "Unknown";

        if (csvXtractThread.isRunning()){
            status = "Running";
        } else {
            status = "Stopped";
        }

        return status;
    }

    public static String getLogs() {
        return csvXtract.readLogs();
    }

    public static void stop() {
        csvXtractThread.doStop();
    }

    public static void start() {
        Thread thread = new Thread(csvXtractThread);

        thread.start();
    }
}
