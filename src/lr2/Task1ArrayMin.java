package lr2;

import java.util.Arrays;
import java.util.Random;

public class Task1ArrayMin {
    public static void main(String[] args) {
        int n = 10; // размер массива

        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // случайные числа от 0 до 99
        }

        System.out.println("Массив: " + Arrays.toString(array));

        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        System.out.println("Минимальное значение: " + minValue);
        System.out.print("Индексы минимального значения: ");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == minValue) {
                System.out.print(i + " ");
            }
        }
    }
}
