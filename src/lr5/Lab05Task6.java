package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab05Task6 {

    public static void main(String[] args) {
        runTask6();
    }

    public static void runTask6() {
        Random random = new Random();

        // Создаём список из 15 случайных целых чисел в диапазоне 0..99
        List<Integer> numbers = Arrays.asList(
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100),
                random.nextInt(100), random.nextInt(100), random.nextInt(100)
        );

        Scanner in = new Scanner(System.in);
        System.out.println("Введите число-делитель:");
        int divisor = in.nextInt();

        System.out.println("\nИсходный список чисел:\n");
        for (Integer n : numbers) {
            System.out.println(n);
        }

        List<Integer> result = divisibleBy(numbers, divisor);

        System.out.println("\nЧисла, которые делятся на " + divisor + " без остатка:\n");
        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> divisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}