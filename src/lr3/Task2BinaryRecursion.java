import java.util.Scanner;

public class Task2BinaryRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Двоичный вид: 0");
        } else {
            System.out.print("Двоичный вид: ");
            if (n < 0) {
                System.out.print("-");
                n = -n;
            }
            toBinary(n);
            System.out.println();
        }
    }

    public static void toBinary(int n) {
        if (n == 0) {
            return;
        }
        toBinary(n / 2);
        System.out.print(n % 2);
    }
}