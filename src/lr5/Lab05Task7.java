package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Lab05Task7 {

    public static void main(String[] args) {
        runTask7();
    }

    public static void runTask7() {
        List<String> strings = Arrays.asList(
                "Java",
                "Stream",
                "API",
                "Лабораторная",
                "строка",
                "длина",
                "фильтрация"
        );

        Scanner in = new Scanner(System.in);
        System.out.println("Введите минимальную длину строки:");
        int minLength = in.nextInt();

        System.out.println("\nИсходный список строк:\n");
        for (String s : strings) {
            System.out.println(s + " (len=" + s.length() + ")");
        }

        List<String> result = longerThan(strings, minLength);

        System.out.println("\nСтроки, длина которых больше " + minLength + ":\n");
        for (String s : result) {
            System.out.println(s + " (len=" + s.length() + ")");
        }
    }

    public static List<String> longerThan(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}