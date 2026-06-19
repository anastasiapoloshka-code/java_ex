package lr7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab7example6 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example6");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File logFile = new File(folder, "log.txt");

        // Запись данных в файл с использованием PrintWriter
        try (PrintWriter fileWriter = new PrintWriter(logFile)) {
            fileWriter.println("Лог работы программы Lab7example6:");
            fileWriter.println("-------------------------------");
            fileWriter.println("Первая строка лога.");
            fileWriter.printf("Число: %d, строка: %s%n", 42, "пример форматированного вывода");
            fileWriter.println("Завершение записи в файл log.txt.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при открытии файла для записи: " + e.getMessage());
            return;
        }

        // Вывод информации в консоль с использованием PrintWriter
        try (PrintWriter consoleWriter = new PrintWriter(System.out, true)) {
            consoleWriter.println("Запись в файл log.txt завершена.");
            consoleWriter.println("Путь к файлу: " + logFile.getAbsolutePath());
            consoleWriter.println("Содержимое файла log.txt:");

            try (Scanner scanner = new Scanner(logFile)) {
                while (scanner.hasNextLine()) {
                    consoleWriter.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                consoleWriter.println("Не удалось прочитать файл log.txt: " + e.getMessage());
            }
        }
    }
}