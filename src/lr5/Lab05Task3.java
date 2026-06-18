package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab05Task3 {

    public static void main(String[] args) {
        runTask3();
    }

    public static void runTask3() {
        String text = "Напишите функцию, которая принимает на вход список строк "
                + "и возвращает новый список, содержащий только те строки, "
                + "которые начинаются с большой буквы.";

        // Для наглядности разобьём текст на отдельные строки по пробелам
        // или по символу перевода строки, если ты добавишь \n в исходную строку.
        List<String> strings = Arrays.asList(text.split(" "));

        System.out.println("Строки до фильтрации:");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> stringsAfter = filterCapitalized(strings);

        System.out.println("\nСтроки после фильтрации (начинаются с заглавной буквы):");
        for (String s : stringsAfter) {
            System.out.println(s);
        }
    }

    public static List<String> filterCapitalized(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}