import java.util.Scanner;

public class ManageStaffAccs {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int managestaffmenu;
        //CREATE A NEW STAFF ACCOUNT
        String[] staffdetails  = {"Enter new staff username: ", "Enter new staff password: "};
        String[][] staffdetailsinput=new String[5][3];
        int staffcont = 0;
        //DISPLAY STAFF
        String[] display = {"#","Username","Status","Last Log In"};

        do {
            System.out.println("===================================");
            System.out.println("MANAGE STAFF ACCOUNTS");
            System.out.println("===================================");
            System.out.println("1. Create New Staff Account");
            System.out.println("2. View All Staff");
            System.out.println("3. Back to Dashboard");
            managestaffmenu = input.nextInt();

            if (managestaffmenu == 1) {

                do {
                    for (int i = 0; i < 5; i++) {
                        input.nextLine();
                        for (int j = 0; j < 2; j++) {
                            System.out.print(staffdetails[j] + " ");
                            staffdetailsinput[i][j] = input.nextLine();
                        }
                        System.out.println("Staff account created successfully");
                        System.out.print("Do you want to create another account? [1] Yes [2] No ");
                        staffcont=input.nextInt();
                        if (staffcont==2){
                            break;
                        }
                    }
                }while (staffcont!=2);
            }
            else if (managestaffmenu == 2) {
                


            }
            else if (managestaffmenu == 3) {

            }
            else {

            }
        } while (true);
    }
}
