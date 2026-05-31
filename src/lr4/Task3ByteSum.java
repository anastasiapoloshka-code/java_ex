package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3ByteSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt(); // возможен InputMismatchException

            if (n <= 0) {
                System.out.println("Размер массива должен быть положительным.");
                return;
            }

            byte[] array = new byte[n];
            System.out.println("Введите " + n + " целых чисел в диапазоне от "
                    + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ":");

            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt(); // читаем как int

                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    System.out.println("Ошибка: значение " + value
                            + " выходит за пределы диапазона типа byte.");
                    return;
                }

                array[i] = (byte) value;
            }

            int sum = 0;
            for (byte b : array) {
                sum += b; // считаем в int, чтобы увидеть переполнение явно при необходимости
            }

            // проверка, помещается ли сумма в byte
            if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                System.out.println("Ошибка: сумма элементов (" + sum
                        + ") выходит за пределы диапазона типа byte.");
            } else {
                byte result = (byte) sum;
                System.out.println("Сумма элементов массива (byte): " + result);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
        } finally {
            scanner.close();
        }
    }
}