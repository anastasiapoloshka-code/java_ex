package lr2;

import java.util.Scanner;

public class Task3CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем текст
        System.out.println("Введите текст для шифрования:");
        String input = scanner.nextLine();

        // Запрашиваем ключ сдвига
        System.out.println("Введите ключ (целое число):");
        int key = scanner.nextInt();
        scanner.nextLine(); // очищаем перевод строки

        // Прямое шифрование
        String encrypted = shiftString(input, key);
        System.out.println("Текст после преобразования: " + encrypted);

        // Вопрос про обратное преобразование
        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            String decrypted = shiftString(encrypted, -key);
            System.out.println("Текст после обратного преобразования: " + decrypted);
        } else if (answer.equals("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }

    // Метод сдвигает каждый символ строки на заданное количество позиций
    private static String shiftString(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int code = (int) ch;
            code += key;
            char shifted = (char) code;
            result.append(shifted);
        }

        return result.toString();
    }
}
