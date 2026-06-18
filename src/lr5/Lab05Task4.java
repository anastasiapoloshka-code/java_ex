package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lab05Task4 {

    public static void main(String[] args) {
        runTask4();
    }

    public static void runTask4() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        System.out.println("Список до возведения в квадрат:\n");

        // Заполняем список 10 случайными числами в диапазоне 0..999
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(1000);
            numbers.add(value);
            System.out.println(value);
        }

        // Получаем новый список, содержащий квадраты исходных чисел
        List<Integer> squares = squareList(numbers);

        System.out.println("\nСписок после возведения в квадрат:\n");

        for (Integer sq : squares) {
            System.out.println(sq);
        }
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)   // возводим каждый элемент в квадрат
                .collect(Collectors.toList());
    }
}