package lr4;

public class Task1AveragePositiveArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не переданы аргументы командной строки. "
                    + "Ожидается последовательность целых чисел.");
            return;
        }

        int[] array = new int[args.length];

        // чтение и проверка аргументов
        for (int i = 0; i < args.length; i++) {
            String token = args[i];
            try {
                array[i] = Integer.parseInt(token); // возможен NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println("Ошибка формата числа: \"" + token
                        + "\". Ожидалось целое число.");
                return;
            }
        }

        int sumPositive = 0;
        int countPositive = 0;

        for (int value : array) {
            if (value > 0) {
                sumPositive += value;
                countPositive++;
            }
        }

        if (countPositive == 0) {
            System.out.println("Положительные элементы отсутствуют. "
                    + "Невозможно вычислить среднее значение.");
        } else {
            double average = (double) sumPositive / countPositive;
            System.out.println("Среднее значение среди положительных элементов: " + average);
        }
    }
}