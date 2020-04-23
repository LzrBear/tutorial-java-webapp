package hello;

public class csvXtractRunnable implements Runnable {

    private boolean doStop = false;
    private boolean csvXtractRunning = false;

    public synchronized void doStop() {
        csvXtractRunning = false;
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public boolean isRunning() {
        return csvXtractRunning;
    }

    @Override
    public void run() {

        doStop = false;
        csvXtractRunning = true;
        int rounds = 3;

        csvXtract.writeLogs("Starting");

        while(keepRunning() && rounds > 0) {

            csvXtract.writeLogs("Running - rounds left: " + rounds);

            // keep doing what this thread should do.
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rounds--;
        }

        csvXtract.writeLogs("Stopped");

        csvXtractRunning = false;
    }

}