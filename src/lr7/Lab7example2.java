package lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Lab7example2 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example2");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "example_file.txt");

        // Ввод данных для записи из консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для записи в файл:");
        String data = scanner.nextLine();

        // Запись данных в файл через байтовый поток
        try (FileOutputStream fos = new FileOutputStream(file)) {
            System.out.println("Начало записи в файл: " + file.getAbsolutePath());
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Записано байт: " + bytes.length);
            System.out.println("Запись в файл завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение данных из файла через байтовый поток
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println("Начало чтения из файла: " + file.getAbsolutePath());
            byte[] buffer = new byte[fis.available()];
            int readBytes = fis.read(buffer);
            System.out.println("Прочитано байт: " + readBytes);

            String fileContent = new String(buffer);
            System.out.println("Содержимое файла:");
            System.out.println(fileContent);

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