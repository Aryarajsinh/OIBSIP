package task_2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Number_Guessing_Game {

    protected static void number_guessing_game() {
        double r = Math.random() * 100;
        int a = (int) r;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("""
                    choose :-\s
                     \t1:- Limited attempt\040
                     \t2:-UnLimited attempt""");
            System.out.print("Enter Your Choice:");
            int n = sc.nextInt();
            var count = new AtomicInteger();
            switch (n) {
                case 1:
                    count.set(0);
                    System.out.println("\n->\tThere are 7 attempt to find the number ");

                    while (count.get() < 7) {
                        System.out.print("Enter the number :");
                        int m = sc.nextInt();
                        if (m == a) {
                            System.out.println("<-------------------------------- || Congratulation You Win This Number_Guessing_Game || --------------------------------------->");
                            System.out.println("->\tYour score :" + (count.get() + 1));
                            System.out.println("->\tYou Earn :" + 7 * (7 - count.get() - 1) + " " + "point");
                            return;
                        } else if (m > a) {

                            for (String s : Arrays.asList("\n->Your Number is Greater Then Random Number ", "Here " + (7 - count.get() - 1) + " Attempt is remaining")) {
                                System.out.println(s);
                            }

                        } else {

                            for (String s : Arrays.asList("\n-> Your Number is Smaller Then Random Number ", "Here " + (7 - count.get() - 1) + " Attempt is remaining")) {
                                System.out.println(s);
                            }
                        }

                        count.getAndIncrement();
                    }
                    System.out.println("\n<--------!!  Better Luck Next Time  !!---------->");
                    number_guessing_game();
                case 2:
                    count.set(0);
                    System.out.println("->There many attempt to find the number ");

                    while (true) {
                        System.out.println("Enter the number :-");
                        int k = sc.nextInt();
                        if (k == a) {
                            System.out.println("<--------------------------------Congratulation You Win This Number_Guessing_Game----------------------------------->");
                            if ((7 - count.get() - 1) > 0) {
                                System.out.println("Your score :" + (count.get() + 1));
                                System.out.println("You Earn " + 7 * (7 - count.get() - 1) + "\tpoint");
                            } else {
                                System.out.println("No point given for :" + (count.get() + 1) + "attempt");
                            }
                            return;
                        } else if (k > a) {
                            System.out.println("\nYour Number is Greater Then Random Number ");

                        } else {
                            System.out.println("\nYour Number is Smaller Then Random Number ");
                        }

                        count.getAndIncrement();
                    }
                default:
                    System.out.println("Enter valid number :-");
                    number_guessing_game();

            }
        }

    }

    public static void main(String[] args) {
        try {
            number_guessing_game();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}





