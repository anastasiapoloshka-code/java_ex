package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Lab05Example3 {

    public static void main(String[] args) {
        example3();
    }

    public static void example3() {

        String text = "Напишите функцию, которая принимает на вход список строк "
                + "и возвращает новый список, содержащий только те строки, "
                + "которые начинаются с большой буквы.";

        // Разбиваем исходный текст на строки по символу перевода строки
        // (для примера можно заранее расставить \n в строке или заменить разделитель)
        List<String> strings = List.of(text.split("\n"));

        System.out.println("Строки после разбиения:");
        for (String s : strings) {
            System.out.println(s);
        }

        // Фильтруем строки, оставляя только те, которые начинаются с заглавной буквы
        List<String> stringsAfter = filterCapitalizedStrings(strings);

        System.out.println("\nСтроки после преобразования:");
        for (String s : stringsAfter) {
            System.out.println(s);
        }
    }

    /**
     * Возвращает новый список, содержащий только строки,
     * которые начинаются с заглавной буквы.
     */
    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}