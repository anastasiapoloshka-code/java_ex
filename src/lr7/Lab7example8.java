package lr7;

import java.io.*;

public class Lab7example8 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example8");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "example_text.txt");

        // Подготовка файла с текстом для примера
        String[] lines = {
                "Первая строка текста.",
                "Вторая строка текста.",
                "Третья строка текста.",
                "Четвёртая строка текста."
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            System.out.println("Начало записи тестовых строк в файл: " + file.getAbsolutePath());
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Запись тестовых строк завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Подсчёт количества строк в файле
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Начало чтения файла и подсчёта строк: " + file.getAbsolutePath());
            String line;
            System.out.println("Содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("Чтение файла завершено.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        System.out.println("Общее количество строк в файле: " + lineCount);
    }
}