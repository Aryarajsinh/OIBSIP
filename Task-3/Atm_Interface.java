package task_3;

import java.util.*;

public class Atm_Interface extends User {

    public static void login() {
        ArrayList<String> UserId = new ArrayList<>();
        Collections.addAll(UserId, "aryaraj15", "DK10", "Gkb26", "ram@123", "Shyam@321", "kishan@36");

        List<Integer> UserPin = new ArrayList<>();
        Collections.addAll(UserPin, 1254, 1364, 1634, 3416, 1226, 2463);

        User[] user = new User[3];
        user[0] = new User();
        user[1] = new User();
        user[2] = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            liable_1:
            {
                System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                System.out.println("\t<-------------------------------: || First Required Login Your Self  || :---------------------------------->");
                System.out.print("Enter user_id : ");
                String user_id = sc.next();
                System.out.print("Enter 4 Digit user_pin : ");
                Integer s1;
                s1 = sc.nextInt();
                boolean a = false;
                for (int i = 0; i < UserId.size(); i++) {
                    if (UserId.get(i).equals(user_id) && UserPin.get(i).equals(s1)) {
                        a = true;
                        while (true) {
                            System.out.println("");
                            System.out.println("\tOption : 1->Balance\t2->Transfer\t3->Deposit\t4->Withdraw\t5->Transaction_History\t6->Another_Login\t7->quit");
                            System.out.println("");
                            System.out.print("-> Enter Your Choice :");
                            int p = sc.nextInt();
                            switch (p) {
                                case 1:
                                    user[i].balance();
                                    break;
                                case 2:
                                    int[] k = user[i].transfer(UserId);
                                    user[k[0]].setMoney(user[k[0]].getMoney() + k[1]);
                                    break;

                                case 3:
                                    user[i].deposit();
                                    break;
                                case 4:
                                    user[i].withdraw();
                                    break;
                                case 5:
                                    user[i].transaction_history();
                                    break;
                                case 6:
                                    break liable_1;
                                case 7:
                                    return;
                                default:
                                    System.out.println("Not valid number....");
                            }
                        }
                    }
                }
                System.out.println("Id or Password is Wrong...!!");
            }
        }
    }


    public static void main(String[] args) {
        try {
            login();
        }
        catch (Exception e) {
            System.out.println("Something Was Wrong So Try Again...!!" + e);
        }
    }
}


