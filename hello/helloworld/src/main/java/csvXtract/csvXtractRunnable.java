package csvXtract;

public class csvXtractRunnable implements Runnable {

    public String getLogs() {
        return csvXtract.readLogs();
    }

    public synchronized void stop() {
        csvXtract.terminate();
    }

    @Override
    public void run() {
        System.out.println("Starting Thread");
        csvXtract.doWork();
        System.out.println("Stopped Thread");
    }

}