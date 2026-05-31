import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task6JosephusLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int n = scanner.nextInt();

        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            System.out.println("Удалён: " + people.remove(index));
        }

        System.out.println("Остался человек № " + people.get(0));
    }
}