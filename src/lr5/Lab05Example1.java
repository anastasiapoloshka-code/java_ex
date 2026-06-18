package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab05Example1 {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        // Создаём массив указанного пользователем размера
        int[] arr = new int[size];

        Random random = new Random();

        // Заполняем массив случайными целыми числами
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(); // можно random.nextInt(100) для меньших чисел
        }

        System.out.println("Исходный массив arr:");
        System.out.println(Arrays.toString(arr));

        // Вызываем функцию фильтрации чётных чисел
        int[] arrResult = filterEvenNumbers(arr);

        System.out.println("Массив arrResult (только чётные числа):");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}