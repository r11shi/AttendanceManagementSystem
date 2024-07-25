package ams.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringJoiner;

import ams.util.rw;

public class attendance {
    private static final String filename = "src/resources/attendance.csv";
    public static void checkIn(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter check-in date (yyyy-MM-dd):");
        String date = scanner.nextLine();
        System.out.println("Enter check-in time (HH:mm:ss):");
        String time = scanner.nextLine();
        
        String data = username + ",check-in," + date + "," + time;
        rw.writeCSV(data, filename);
        System.out.println("Check-in successful for " + username + " at " + date + " " + time);
    }

    public static void checkOut(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter check-out date (yyyy-MM-dd):");
        String date = scanner.nextLine();
        System.out.println("Enter check-out time (HH:mm:ss):");
        String time = scanner.nextLine();

        String data = username + ",check-out," + date + "," + time;
        rw.writeCSV(data, filename);
        System.out.println("Check-out successful for " + username + " at " + date + " " + time);
    }
    
   
    public static void generateReport(String username, String filename) {
        System.out.println("Attendance Report for " + username);
        System.out.println("-------------------------------------------------");
        System.out.println("| Staff Member   | Attendance  | Date       | Time    |");
        System.out.println("-------------------------------------------------");

          BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4 && data[0].equals(username)) {
                    StringJoiner sj = new StringJoiner("   |   ");
                    for (int i = 1; i < 4; i++) {
                        sj.add(data[i]);
                    }
                    System.out.println(username + "   |   " + sj.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("-------------------------------------------------");
    }
}
