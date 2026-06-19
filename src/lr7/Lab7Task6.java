package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab7Task6 {
    public static void main(String[] args) {
        // Фиксированный путь к файлу внутри проекта
        String filePath = "src/lr7/example8/example_text.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для поиска:");
        String word = scanner.nextLine();

        int lineNumber = 0;
        int foundCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Поиск слова \"" + word + "\" в файле: " + filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(word)) {
                    foundCount++;
                    System.out.println("Строка " + lineNumber + ": " + line);
                }
            }

            if (foundCount == 0) {
                System.out.println("Слово \"" + word + "\" в файле не найдено.");
            } else {
                System.out.println("Общее количество строк, содержащих слово \"" + word + "\": " + foundCount);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}