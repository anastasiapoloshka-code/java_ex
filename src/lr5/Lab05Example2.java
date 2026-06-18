package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Lab05Example2 {

    public static void main(String[] args) {
        example2();
    }

    public static void example2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массивов:");
        int size = in.nextInt();

        // Создаём два массива указанного пользователем размера
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        Random random = new Random();

        // Заполняем оба массива случайными целыми числами в диапазоне 0..199
        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(200);
            arr2[i] = random.nextInt(200);
        }

        System.out.println("Массив arr1:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Массив arr2:");
        System.out.println(Arrays.toString(arr2));

        // Находим общие элементы двух массивов
        int[] arrResult = findCommonElements(arr1, arr2);

        System.out.println("Массив arrResult (общие элементы arr1 и arr2):");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .toArray();
    }
}