package ams.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class rw{
    //private static final String CSV_FILE_PATH = "D:\\attendance.csv";

  
    public static void writeCSV(String data, String csvFilePath) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csvFilePath, true));
            bw.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readCSV(String csvFilePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close(); // Closing BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
