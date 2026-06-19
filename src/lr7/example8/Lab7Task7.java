package lr7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab7Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу, в который нужно записать текст:");
        String filePath = scanner.nextLine();

        System.out.println("Введите текст для записи в файл:");
        String text = scanner.nextLine();

        int charCount = text.length();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            System.out.println("Начало записи текста в файл: " + filePath);
            writer.write(text);
            System.out.println("Запись текста завершена.");
            System.out.println("Количество записанных символов: " + charCount);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}