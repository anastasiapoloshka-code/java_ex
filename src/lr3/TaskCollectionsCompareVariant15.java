import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class TaskCollectionsCompareVariant15 {
    private static final int N = 100_000;

    public static void main(String[] args) {
        compareAddOperations();
        compareRemoveOperations();
        compareGetOperations();
    }

    private static void compareAddOperations() {
        System.out.println("=== ДОБАВЛЕНИЕ ===");

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.addFirst(i);
        long end = System.nanoTime();
        System.out.println("ArrayDeque addFirst: " + (end - start) / 1_000_000.0 + " мс");

        deque.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.addLast(i);
        end = System.nanoTime();
        System.out.println("ArrayDeque addLast: " + (end - start) / 1_000_000.0 + " мс");

        ArrayList<Integer> list = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(0, i);
        end = System.nanoTime();
        System.out.println("ArrayList add(0, i): " + (end - start) / 1_000_000.0 + " мс");

        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(i);
        end = System.nanoTime();
        System.out.println("ArrayList add(i): " + (end - start) / 1_000_000.0 + " мс");

        TreeSet<Integer> set = new TreeSet<>();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) set.add(i);
        end = System.nanoTime();
        System.out.println("TreeSet add(i): " + (end - start) / 1_000_000.0 + " мс");
    }

    private static void compareRemoveOperations() {
        System.out.println("\n=== УДАЛЕНИЕ ===");

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) deque.addLast(i);
        long start = System.nanoTime();
        while (!deque.isEmpty()) deque.removeFirst();
        long end = System.nanoTime();
        System.out.println("ArrayDeque removeFirst: " + (end - start) / 1_000_000.0 + " мс");

        for (int i = 0; i < N; i++) deque.addLast(i);
        start = System.nanoTime();
        while (!deque.isEmpty()) deque.removeLast();
        end = System.nanoTime();
        System.out.println("ArrayDeque removeLast: " + (end - start) / 1_000_000.0 + " мс");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        start = System.nanoTime();
        while (!list.isEmpty()) list.remove(0);
        end = System.nanoTime();
        System.out.println("ArrayList remove(0): " + (end - start) / 1_000_000.0 + " мс");

        for (int i = 0; i < N; i++) list.add(i);
        start = System.nanoTime();
        while (!list.isEmpty()) list.remove(list.size() - 1);
        end = System.nanoTime();
        System.out.println("ArrayList remove(last): " + (end - start) / 1_000_000.0 + " мс");

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) set.add(i);
        start = System.nanoTime();
        while (!set.isEmpty()) set.pollFirst();
        end = System.nanoTime();
        System.out.println("TreeSet pollFirst: " + (end - start) / 1_000_000.0 + " мс");
    }

    private static void compareGetOperations() {
        System.out.println("\n=== ПОЛУЧЕНИЕ ЭЛЕМЕНТА ===");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        int x = list.get(N / 2);
        long end = System.nanoTime();
        System.out.println("ArrayList get(mid): " + (end - start) + " нс, значение = " + x);

        System.out.println("ArrayDeque: получение по индексу не поддерживается напрямую");
        System.out.println("TreeSet: получение по индексу не поддерживается");
    }
}