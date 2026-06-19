package lr7;

import java.io.File;
import java.util.Scanner;

public class Lab7Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
            return;
        }

        long size = file.length();
        System.out.println("Путь к файлу: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + size + " байт");
    }
}