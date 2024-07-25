package ams.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class auth{
    private static final String CSV_FILE_PATH = "src/resources/users.csv";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123";

    public static void userAuth(String username, String password) {
        boolean isAuthenticated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2 && data[0].equals(username) && data[1].equals(password)) {
                    isAuthenticated = true;
                    break; // Exit the loop if authentication successful
                }
            }

            if (isAuthenticated) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void adminAuth(String username, String password) {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Authentication successful!"); 
        } else {
            System.out.println("Authentication failed."); 
            System.exit(0);
        }
    }
}
