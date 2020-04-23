package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class csvXtract {

    final static String fileName = "logs.txt";

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