
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
                 break;
            }

        }
    }

    public static void displayStaffs(String[][] staffs, int count){
        String[] headers = {"#", "Username", "Status", "Last Login"};

        for (String header:headers){
            System.out.print(header + "\t");
        }

        System.out.println();
        for (int i=0; i<count; i++){
            System.out.print((i+1) + "\t");
            for (int j=0; j<staffs[i].length; j++){
            if (j==1){
                continue;
            }
                System.out.print(staffs[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

