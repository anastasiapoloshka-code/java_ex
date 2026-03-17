package lr1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input age:");
        int age = in.nextInt();

        int currentYear = 2026;
        int yearOfBirth = currentYear - age;

        System.out.println("Your year of birth is " + yearOfBirth);
        in.close();
    }
}
