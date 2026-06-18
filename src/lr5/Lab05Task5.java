package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Lab05Task5 {

    public static void main(String[] args) {
        runTask5();
    }

    public static void runTask5() {
        List<String> strings = Arrays.asList(
                "Java Stream API",
                "Функциональное программирование",
                "Подстрока и фильтрация",
                "Лабораторная работа 5",
                "Stream и лямбда-выражения"
        );

        Scanner in = new Scanner(System.in);
        System.out.println("Введите подстроку для поиска:");
        String substr = in.nextLine();

        System.out.println("\nИсходный список строк:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> filtered = filterBySubstring(strings, substr);

        System.out.println("\nСтроки, содержащие подстроку \"" + substr + "\":\n");
        for (String s : filtered) {
            System.out.println(s);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substr) {
        return list.stream()
                .filter(s -> s.contains(substr))
                .collect(Collectors.toList());
    }
}