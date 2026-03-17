package lr1;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number:");
        int x = in.nextInt();

        int x1 = x - 1;
        int x2 = x;
        int x3 = x + 1;
        int x4 = (x1 + x2 + x3) * (x1 + x2 + x3);

        System.out.println("x - 1 = " + x1);
        System.out.println("x = " + x2);
        System.out.println("x + 1 = " + x3);
        System.out.println("Square of sum = " + x4);
        in.close();
    }
}
