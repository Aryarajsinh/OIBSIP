package task_3;
import java.util.*;

public class User {

    private int money = 0;

    private  final ArrayList<String> history = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public User() {
    }

    protected void balance() {
        System.out.println("Your Available Balance is : " + money);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int[] transfer(ArrayList<String> array) {

        int[] a = new int[2];
        int k = 0;
        System.out.print("Enter the receiver id :");
        String receiver_id = sc.next();
        System.out.print("Enter  transfer money :");
        int transfer_money = sc.nextInt();

        if (transfer_money > money) {
            System.out.println("Not enough balance for transfer ");
        } else {
            money = money - transfer_money;
            System.out.println("Successfully Transfer " + receiver_id + " amount");
            history.add("Transfer " + receiver_id + " amount to " + transfer_money + " account");
            for (int i = 0; i < array.size(); i++) {
                if ((array.get(i)).equals(receiver_id)) {
                    k = i;
                    break;
                }
            }
            a[0] = k;
            a[1] = transfer_money;
            return a;
        }
        for (int i = 0; i < array.size(); i++) {
            if ((array.get(i)).equals(receiver_id)) {
                k = i;
                break;
            }
        }
        a[0] = k;
        return a;
    }
    public void deposit() {

        System.out.print("Enter the Amount for Deposit :");
        int deposit = sc.nextInt();
        money = money + deposit;
        System.out.println("Successfully Deposit " + deposit + " amount");
        history.add("Deposit " + deposit + " amount");
    }


    public void withdraw() {

        System.out.print("Enter the amount for Withdraw :");
        int withdraw = sc.nextInt();
        if (withdraw > money) {
            System.out.println("Not found because Withdraw amount is larger then your balance");
        } else {
            money = money - withdraw;
            System.out.println("Successfully Withdraw " + withdraw + " amount");
            history.add("Withdraw " + withdraw + " amount");
        }
    }


    public void transaction_history() {
        if (history.size() > 0) {
            for (String o : history) {
                System.out.println(o);
            }
        } else {
            System.out.println("Not history available...");
        }
    }
}

