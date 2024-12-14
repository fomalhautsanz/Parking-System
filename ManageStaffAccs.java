
import java.time.format.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Scratch {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //SCANNER FOR MENU
        int managestaffmenu;
        //1. CREATE NEW STAFF ACC
        String[][] staffs = new String[5][4];
        int count=0;
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss a");

        while (true){
            System.out.println("===================================");
            System.out.println("MANAGE STAFF ACCOUNTS");
            System.out.println("===================================");
            System.out.println("1. Create New Staff Account");
            System.out.println("2. View All Staff");
            System.out.println("3. Back to Dashboard");
            System.out.print("Select an option: ");

            managestaffmenu = input.nextInt();
            input.nextLine();

            switch (managestaffmenu){
                case 1:
                if (count>=staffs.length){
                    System.out.println("Limit reached. Cannot create more accounts. Please contact the system developers.");
                }
                else {
                        System.out.print("Enter new staff username: ");
                        staffs[count][0] = input.nextLine();
                        System.out.print("Enter new staff password: ");
                        staffs[count][1] = input.nextLine();
                        staffs[count][2] = "Active";
                        LocalDateTime loginDateTime  = LocalDateTime.now();
                        String convertedloginDateTime = loginDateTime.format(formatter);
                        staffs[count][3] = convertedloginDateTime;
                        count++;
                }
                break;

                case 2:
                 displayStaffs(staffs,count);
                 System.out.println("Actions: ");
                 System.out.println("1. Deactivate a Staff Account");
                 System.out.println("2. Reset Staff Password");
                 System.out.println("3. Back to Manage Staff Menu: ");
                 int actions = input.nextInt();

                 if (actions==1){
                     input.nextLine();
                     deactivateAcc(staffs,input,count);
                 }
                 else if (actions==2) {
                     input.nextLine();
                     resetPassword(staffs,input,count);
                 }
                    break;
            }
        }
    }

    public static void displayStaffs(String[][] staffs, int count) {
        System.out.printf("%-4s %-15s %-10s %-20s%n", "#", "Username", "Status", "Last Login");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-4d %-15s %-10s %-20s%n", (i + 1), staffs[i][0], staffs[i][2], staffs[i][3]);
        }
    }

    public static void deactivateAcc (String[][] staffs, Scanner input, int count){
        System.out.print("Enter staff username to deactivate: ");
        String username = input.nextLine();
        boolean userFound = false;
        for (int i=0; i<count; i++){
            if (Objects.equals(username, staffs[i][0])) {
                System.out.println("Confirm account deactivation y/n");
                String confirm = input.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    staffs[i][2] = "Inactive";
                    System.out.println("Staff account " + staffs[i][0] + " has been successfully deactivated.");
                }
                userFound = true;
                break;
            }
        }
        if (!userFound){
            System.out.println("User not found. ");
        }
    }

    public static void resetPassword(String[][] staffs, Scanner input, int count) {
        System.out.print("Enter staff username to reset password: ");
        String username = input.nextLine();
        boolean userFound = false;

        for (int i = 0; i < count; i++) {
            if (Objects.equals(username, staffs[i][0])) {
                userFound = true;
                while (true) {
                    System.out.println("New password for [" + staffs[i][0] + "]: ");
                    String newPassword = input.nextLine();
                    System.out.print("Confirm password: ");
                    String confirmPassword = input.nextLine();
                    if (!Objects.equals(confirmPassword, newPassword)) {
                        System.out.println("Passwords don't match. Please try again.");
                    } else {
                        staffs[i][1] = newPassword;
                        System.out.println("Password for [" + staffs[i][0] + "] has been successfully reset.");
                        return;
                    }
                }
            }
        }
        if (!userFound) {
            System.out.println("User not found.");
        }
    }


}
