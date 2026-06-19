package lr7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab7example3 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example3");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "example_file.txt");
        String data = "Пример строки data для записи в файл через символьные потоки.";

        // Запись данных в файл через FileWriter
        try (FileWriter writer = new FileWriter(file)) {
            System.out.println("Начало записи в файл (FileWriter): " + file.getAbsolutePath());
            writer.write(data);
            System.out.println("Запись строки завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла через FileReader
        try (FileReader reader = new FileReader(file)) {
            System.out.println("Начало чтения из файла (FileReader): " + file.getAbsolutePath());

            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }

            System.out.println("Содержимое файла:");
            System.out.println(sb);

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