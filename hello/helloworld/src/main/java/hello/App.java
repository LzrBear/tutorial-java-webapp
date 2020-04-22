package hello;

/**
 * Hello world!
 *
 */
public class App 
{
    private static csvXtractRunnable csvXtract = new csvXtractRunnable();

    public static void main( String[] args )
    {
        System.out.println("CSVXtract Status: " + getStatus());

        System.out.println("Starting CSVXtract");
        start();

        try {
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);
            System.out.println("CSVXtract Status: " + getStatus());
            Thread.sleep(1);

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
        return "Koala";
    }

    public static String getStatus() {
        String status = "Unknown";

        if (csvXtract.isRunning()){
            status = "Running";
        } else {
            status = "Stopped";
        }

        return status;
    }

    public static void stop() {
        csvXtract.doStop();
    }

    public static void start() {
        Thread thread = new Thread(csvXtract);

        thread.start();
    }
}
