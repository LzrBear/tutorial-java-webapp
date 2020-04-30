package csvXtract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class csvXtract {

    private final static String fileName = "logs.txt";
    private static boolean terminate = false;

    public static void doWork() {

        terminate = false;
        csvXtract.writeLogs("Starting Work");
        int rounds = 5;

        while (rounds > 0 && !terminate) {
            
            System.out.println("Do something - rounds left: " + rounds);
            csvXtract.writeLogs("Do something - rounds left: " + rounds);

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                System.out.println("FISH");
                e.printStackTrace();
            }

            rounds--;
        }

        csvXtract.writeLogs("Completed Work");
    }
    
    public static void terminate() {
        terminate = true;
    }

    public static String getLogPath() {
        return System.getProperty("user.dir");
    }

    public static String readLogs(){

        String log = "";

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              log += myReader.nextLine() + "\\n";
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            return "Log file could not be found.";
            //e.printStackTrace();
          }

          return log;
    }

    public static void writeLogs(String data){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateString = dateFormat.format(date); //2016/11/16 12:08:43

        data = dateString + ": " + data + "\n";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //ignore
        }

        data = data + dateString + ": QUACK!\n";

        writeUsingFileWriter(data, fileName);
    }

    private static void writeUsingFileWriter(String data, String FileName) {
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File file = new File(FileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true); //append
            //fr = new FileWriter(file); // do not append
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
}