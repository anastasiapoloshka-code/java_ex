package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Lab05Task1 {

    public static void main(String[] args) {
        runTask1();
    }

    public static void runTask1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        // Создаём массив указанного размера
        int[] arr = new int[size];

        Random random = new Random();

        // Заполняем массив случайными целыми числами
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(); // при желании можно ограничить диапазон: nextInt(1000)
        }

        System.out.println("Исходный массив arr:");
        System.out.println(Arrays.toString(arr));

        // Получаем новый массив, содержащий только чётные элементы
        int[] arrResult = filterEven(arr);

        System.out.println("Массив arrResult (только чётные числа):");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterEven(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}