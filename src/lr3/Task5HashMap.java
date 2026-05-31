import java.util.HashMap;
import java.util.Map;

public class Task5HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "привет");
        map.put(3, "java");
        map.put(4, "коллекция");
        map.put(5, "код");
        map.put(6, "структура");
        map.put(7, "данные");
        map.put(8, "список");
        map.put(9, "алгоритм");

        System.out.println("Строки, у которых ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        System.out.println("\nСтроки, у которых ключ = 0:");
        boolean first = true;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(entry.getValue());
                first = false;
            }
        }
        System.out.println();

        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        if (found) {
            System.out.println("\nПроизведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("\nНет строк длиной более 5 символов.");
        }
    }
}