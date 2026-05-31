package lr4;

public class Task3ByteSumArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не переданы аргументы командной строки. "
                    + "Ожидается последовательность целых чисел.");
            return;
        }

        byte[] array = new byte[args.length];

        // чтение и проверка элементов
        for (int i = 0; i < args.length; i++) {
            String token = args[i];
            int value;

            try {
                value = Integer.parseInt(token); // возможен NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println("Ошибка формата числа: \"" + token
                        + "\". Ожидалось целое число.");
                return;
            }

            if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                System.out.println("Ошибка: значение " + value
                        + " выходит за пределы диапазона типа byte ("
                        + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE + ").");
                return;
            }

            array[i] = (byte) value;
        }

        int sum = 0;
        for (byte b : array) {
            sum += b; // считаем в int
        }

        if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
            System.out.println("Ошибка: сумма элементов (" + sum
                    + ") выходит за пределы диапазона типа byte ("
                    + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE + ").");
        } else {
            byte result = (byte) sum;
            System.out.println("Сумма элементов массива (byte): " + result);
        }
    }
}