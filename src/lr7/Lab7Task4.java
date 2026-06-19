package lr7;

import java.io.*;
import java.util.Scanner;

public class Lab7Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к исходному текстовому файлу:");
        String sourcePath = scanner.nextLine();

        System.out.println("Введите путь к файлу, в который нужно скопировать содержимое:");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        if (!sourceFile.exists()) {
            System.out.println("Исходный файл не найден: " + sourceFile.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            System.out.println("Начало копирования файла.");
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено успешно.");
            System.out.println("Исходный файл: " + sourceFile.getAbsolutePath());
            System.out.println("Файл‑копия: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}