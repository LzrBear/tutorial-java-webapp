package CSVXtract;

import csvXtract.csvXtract;

class csvXtractRunnable implements Runnable {

    public String getLogPath() {
        return csvXtract.getLogPath();
    }

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