package timus;

import java.util.Scanner;

public class Timus1409 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int harryLeft = in.nextInt();   // сколько банок осталось у Гарри
        int larryLeft = in.nextInt();   // сколько банок осталось у Ларри

        // Всего было harryLeft + larryLeft - 1 банок
        int total = harryLeft + larryLeft - 1;

        // Сколько банок расстрелял Гарри: все, кроме оставшихся у Ларри
        int harryShot = total - harryLeft;

        // Сколько банок расстрелял Ларри: все, кроме оставшихся у Гарри
        int larryShot = total - larryLeft;

        System.out.println(harryShot + " " + larryShot);
    }
}