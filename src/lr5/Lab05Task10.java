package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Lab05Task10 {

    public static void main(String[] args) {
        runTask10();
    }

    public static void runTask10() {
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

        List<Integer> result = lessThan(numbers, threshold);

        System.out.println("\nЧисла, которые меньше " + threshold + ":\n");
        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> lessThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x < threshold)
                .collect(Collectors.toList());
    }
}