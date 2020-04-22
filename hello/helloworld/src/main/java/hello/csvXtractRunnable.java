package hello;

public class csvXtractRunnable implements Runnable {

    private boolean doStop = false;
    private boolean csvXtractRunning = false;

    public synchronized void doStop() {
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
        while(keepRunning()) {

            csvXtractRunning = true;

            // keep doing what this thread should do.
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        csvXtractRunning = false;
    }

}