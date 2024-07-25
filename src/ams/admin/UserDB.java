package ams.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ams.util.rw;

public class UserDB {
    private static final String filename = "src/resources/users.csv";

    public static void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String data = username + "," + password;
        rw.writeCSV(data,filename);
        System.out.println("User " + username + " created successfully.");
    }

    public static void printAllUsers() {
        System.out.println("User Database");
        System.out.println("-------------------------------------");
        System.out.println("Usernames, Passwords");
        System.out.println("-------------------------------------");

        rw.readCSV(filename);

        System.out.println("-------------------------------------");
    }

    public static void adminReport(String filename) {
        System.out.println("Attendance Report for All Users");
        System.out.println("------------------------------------------------------");
        System.out.println("| Staff Member   | Attendance  | Date       | Time    |");
        System.out.println("------------------------------------------------------");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String username = data[0];
                    String status = data[1];
                    String date = data[2];
                    String time = data[3];
                    System.out.println(username + "    |    " +  status + "    |    "+  date + "    |    "+ time);
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

        System.out.println("------------------------------------------------------");
    }
}
