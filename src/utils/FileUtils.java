package src.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FileUtils {

    public static void writeToFile(String fileName) {
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File("/logs" + fileName + timeLog);

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("Hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void writeResultsToFile(String accelRow, long time){
        PrintWriter printWriter = null;
        String data = getTimestampString(time) + ", " + accelRow;

        String dayFormat = "yyyy-MM-dd";
        String hourFormat = "HH-z";
        String minuteForma = "mm";

        Date dateNow = new Date();
        String dayDirectory = new SimpleDateFormat(dayFormat, Locale.US).format(dateNow);
        String hourDirectory = new SimpleDateFormat(hourFormat, Locale.US).format(dateNow);
        String minuteDirectory = new SimpleDateFormat(minuteForma, Locale.US).format(dateNow);

        String watchAccelDataDirectory = "logs" + "/" + dayDirectory + "/" + hourDirectory + "/" + minuteDirectory + "/" + "Data.csv";
        File watchAccelDataFile = new File(watchAccelDataDirectory);

        if(!watchAccelDataFile.getParentFile().exists()){
            watchAccelDataFile.getParentFile().mkdirs();
        }

        if(watchAccelDataFile.exists()) {
            try {
                printWriter =
                        new PrintWriter(new BufferedWriter(new FileWriter(watchAccelDataFile, true)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{
            if (watchAccelDataFile.createNewFile()){
                String headerRow = "timestamp, unixtime, auc, watchWorn, sleepmode, wakemode, waketime, sleeptime";
                if (printWriter != null) {
                    printWriter.println(headerRow);
                    if (printWriter.checkError()) {
                    }
                }
            }else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (printWriter != null) {

            printWriter.println(data);
            if (printWriter.checkError()) {
            }
        }
    }

}

