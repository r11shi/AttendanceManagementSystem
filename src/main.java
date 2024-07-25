import java.util.Scanner;

import ams.admin.UserDB;
import ams.user.attendance;
import ams.util.auth;


public class main {
    private static String username = "";
    private static String password = "";

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        boolean isAdmin = false;
        

        while (true) {
            if (!loggedIn) {
                displayMenu();
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                auth a  = new auth();
                switch (choice) {
                    case 1: 
                        login(sc);
                        a.userAuth(username, password);
                        loggedIn = true;
                        isAdmin = false;
                        break;
                    case 2:
                        login(sc);
                        a.adminAuth(username, password);
                        loggedIn = true;
                        isAdmin = true;
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                }
            }

            
            if (loggedIn) {
                if (isAdmin) {
                    adminMenu(sc);
                } else {
                    userMenu(sc);
                }
                
                loggedIn = false;
                isAdmin = false;
            
            }
        }
    }

    public static void displayMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                  Attendance Management System");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("   Welcome to Attendance Management System!");
        System.out.println();
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   |                                                                 |");
        System.out.println("   |                     Choose an Option:                           |");
        System.out.println("   |                                                                 |");
        System.out.println("   |   1. User Login                                                 |");
        System.out.println("   |   2. Admin Login                                                |");
        System.out.println("   |   3. Exit                                                       |");
        System.out.println("   |                                                                 |");
        System.out.println("   |                                                                 |");
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("   Please enter the number of your choice:");
    }

    public static void login(Scanner sc) {
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   |                                                                 |");
        System.out.println("   |                          Login                                  |");
        System.out.println("   |                                                                 |");
        System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print("   |   Please enter your username:\t");
        username = sc.nextLine();
        System.out.print("   |   Please enter your password:\t");
        password = sc.nextLine();
        
    }

    public static void userMenu(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   |                                                                 |");
            System.out.println("   |                     Choose an Option:                           |");
            System.out.println("   |                                                                 |");
            System.out.println("   |   1. Check In                                                   |");
            System.out.println("   |   2. Check Out                                                  |");
            System.out.println("   |   3. View Attendance                                            |");
            System.out.println("   |   4. Logout                                                     |");
            System.out.println("   |                                                                 |");
            System.out.println("   |                                                                 |");
            System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("   Please enter the number of your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            attendance A = new attendance();
            UserDB b = new UserDB();
            switch (choice) {
                case 1:
                    A.checkIn(username);
                    break;
                case 2:
                    A.checkOut(username);
                    break;
                case 3:
                    A.generateReport(username,"D:\\attendance.csv");
                    break;
                case 4:
                    System.out.println("Logged Out");
                    return ; // Return to the main loop for login
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   |                                                                 |");
            System.out.println("   |                     Choose an Option:                           |");
            System.out.println("   |                                                                 |");
            System.out.println("   |   1. Attendance Report                                          |");
            System.out.println("   |   2. Create user                                                |");
            System.out.println("   |   3. View user Database                                         |");
            System.out.println("   |   4. Logout                                                     |");
            System.out.println("   |                                                                 |");
            System.out.println("   |                                                                 |");
            System.out.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("   Please enter the number of your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            UserDB admin = new UserDB();
          
            switch (choice) {
                case 1:
                    admin.adminReport("D:\\attendance.csv");
                    break;
                case 2:
                    admin.createUser();
                    break;
                case 3:
                    admin.printAllUsers();
                    break;
                case 4:
                    System.out.println("Logged Out");
                    return; // Return to the main loop for login
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
