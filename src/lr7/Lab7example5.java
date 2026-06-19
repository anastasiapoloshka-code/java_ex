package lr7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Lab7example5 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example5");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File inputFile = new File(folder, "input.txt");
        File outputFile = new File(folder, "output.txt");

        // Исходные данные для записи в input.txt
        String[] lines = {
                "Первая строка исходного файла.",
                "Вторая строка исходного файла.",
                "Третья строка исходного файла."
        };

        // Запись данных в input.txt с использованием OutputStreamWriter
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(inputFile),
                        StandardCharsets.UTF_8
                ))) {

            System.out.println("Начало записи в файл input.txt (UTF-8): " + inputFile.getAbsolutePath());
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Запись исходных строк в input.txt завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в input.txt: " + e.getMessage());
        }

        // Чтение из input.txt и запись преобразованных данных в output.txt
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inputFile),
                        StandardCharsets.UTF_8
                ));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream(outputFile),
                             StandardCharsets.UTF_8
                     ))) {

            System.out.println("Начало чтения из input.txt и записи в output.txt (UTF-8).");
            String line;
            while ((line = reader.readLine()) != null) {
                String upper = line.toUpperCase();
                writer.write(upper);
                writer.newLine();
            }
            System.out.println("Преобразование строк в верхний регистр и запись в output.txt завершены.");
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }

        System.out.println("Путь к выходному файлу: " + outputFile.getAbsolutePath());
    }
}