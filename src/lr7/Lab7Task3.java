package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab7Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к текстовому файлу:");
        String filePath = scanner.nextLine();

        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Начало чтения файла: " + filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
            System.out.println("Чтение файла завершено.");
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}