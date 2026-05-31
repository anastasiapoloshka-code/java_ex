package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1AveragePositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt(); // возможен InputMismatchException

            if (n <= 0) {
                System.out.println("Размер массива должен быть положительным.");
                return;
            }

            int[] array = new int[n];
            System.out.println("Введите " + n + " целых чисел:");

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt(); // возможен InputMismatchException
            }

            int sumPositive = 0;
            int countPositive = 0;

            for (int value : array) {
                if (value > 0) {
                    sumPositive += value;
                    countPositive++;
                }
            }

            if (countPositive == 0) {
                System.out.println("Положительные элементы отсутствуют. Невозможно вычислить среднее значение.");
            } else {
                double average = (double) sumPositive / countPositive;
                System.out.println("Среднее значение среди положительных элементов: " + average);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
        } finally {
            scanner.close();
        }
    }
}