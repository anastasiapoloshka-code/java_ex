package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Lab05Task9 {

    public static void main(String[] args) {
        runTask9();
    }

    public static void runTask9() {
        List<String> strings = Arrays.asList(
                "Java",
                "StreamAPI",
                "Лаба5",
                "строка",
                "text123",
                "ТолькоБуквы",
                "hello_world",
                "пример"
        );

        System.out.println("Исходный список строк:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> result = onlyLetters(strings);

        System.out.println("\nСтроки, содержащие только буквы:\n");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> onlyLetters(List<String> list) {
        // Регулярное выражение: только латинские и русские буквы, одна или больше
        return list.stream()
                .filter(s -> s.matches("[A-Za-zА-Яа-я]+"))
                .collect(Collectors.toList());
    }
}