package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab7example4 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example4");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "example_file.txt");
        String data = "Пример строки data для записи в файл с использованием буферизации.";

        // Запись данных в файл с использованием BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            System.out.println("Начало записи в файл (BufferedWriter): " + file.getAbsolutePath());
            writer.write(data);
            writer.newLine();
            writer.write("Вторая строка примера.");
            System.out.println("Запись строк завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла с использованием BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Начало чтения из файла (BufferedReader): " + file.getAbsolutePath());
            String line;
            System.out.println("Содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Чтение из файла завершено.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }

        // Удаление файла
        if (file.exists()) {
            boolean deleted = file.delete();
            System.out.println("Файл удалён: " + deleted);
        }
    }
}