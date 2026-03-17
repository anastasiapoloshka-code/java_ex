package lr1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input month name:");
        String month = in.nextLine();

        System.out.println("Input number of days in this month:");
        int days = in.nextInt();

        System.out.println("Month " + month + " has " + days + " days.");
        in.close();
    }
}
