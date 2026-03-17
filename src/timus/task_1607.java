import java.util.Scanner;

public class task_1607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // стартовая цена Пети
        int b = in.nextInt(); // надбавка Пети
        int c = in.nextInt(); // стартовая цена таксиста
        int d = in.nextInt(); // скидка таксиста
        in.close();

        int p = a; // текущая цена Пети
        int t = c; // текущая цена таксиста

        while (true) {
            if (p >= t) {           // Петя уже не дешевле
                System.out.println(p);
                break;
            }
            p += b;                 // Петя повышает цену
            if (p >= t) {           // таксист не будет просить дороже
                System.out.println(p);
                break;
            }
            t -= d;                 // таксист снижает цену
            if (t <= p) {           // он не станет уходить ниже Пети
                System.out.println(t);
                break;
            }
        }
    }
}
