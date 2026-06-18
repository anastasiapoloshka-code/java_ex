package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Lab05Task8 {

    public static void main(String[] args) {
        runTask8();
    }
    public static void runTask8() {
        Random random = new Random();

        // Список из 15 случайных чисел 0..99
        List<Integer> numbers = Arrays.asList(
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100)
        );

        Scanner in = new Scanner(System.in);
        System.out.println("Введите пороговое значение:");
        int threshold = in.nextInt();

        System.out.println("\nИсходный список чисел:\n");
        for (Integer n : numbers) {
            System.out.println(n);
        }

        List<Integer> result = greaterThan(numbers, threshold);

        System.out.println("\nЧисла, которые больше " + threshold + ":\n");
        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> greaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x > threshold)
                .collect(Collectors.toList());
    }
}