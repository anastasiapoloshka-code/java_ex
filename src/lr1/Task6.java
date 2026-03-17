package lr1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input name:");
        String name = in.nextLine();

        System.out.println("Input year of birth:");
        int year = in.nextInt();

        int currentYear = 2026;
        int age = currentYear - year;

        System.out.println("Name: " + name + ", age: " + age);
        in.close();
    }
}
