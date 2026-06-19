package lr7;

import java.io.File;
import java.io.IOException;

public class Lab7example1 {
    public static void main(String[] args) throws IOException {
        // корневая папка для примера
        File folder = new File("src/lr7/example1/example_folder");
        if (!folder.exists()) {
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            boolean created = folder.mkdirs();
            System.out.println("Папка создана: " + created);
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        File file = new File(folder, "example_file.txt");
        if (!file.exists()) {
            System.out.println("Создаём файл: " + file.getAbsolutePath());
            boolean created = file.createNewFile();
            System.out.println("Файл создан: " + created);
        } else {
            System.out.println("Файл уже существует: " + file.getAbsolutePath());
        }

        System.out.println("Размер файла: " + file.length() + " байт");

        // удаляем файл и папку
        if (file.exists()) {
            boolean deletedFile = file.delete();
            System.out.println("Файл удалён: " + deletedFile);
        }

        if (folder.exists()) {
            boolean deletedFolder = folder.delete();
            System.out.println("Папка удалена: " + deletedFolder);
        }
    }
}