package lr1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input year of birth:");
        int year = in.nextInt();

        int currentYear = 2026; // можно вынести в константу
        int age = currentYear - year;

        System.out.println("Your age is " + age);
        in.close();
    }
}
