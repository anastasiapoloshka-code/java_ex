import java.util.Scanner;

public class MyLinkedList {
    private Node head;

    public void createHead(int n) {
        Scanner scanner = new Scanner(System.in);
        head = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите значение: ");
            int value = scanner.nextInt();
            head = new Node(value, head);
        }
    }

    public void createTail(int n) {
        Scanner scanner = new Scanner(System.in);
        if (n <= 0) return;

        System.out.print("Введите значение: ");
        head = new Node(scanner.nextInt(), null);
        Node tail = head;

        for (int i = 1; i < n; i++) {
            System.out.print("Введите значение: ");
            tail.next = new Node(scanner.nextInt(), null);
            tail = tail.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value).append(" ");
            ref = ref.next;
        }
        return sb.toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newNode;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node ref = head;
        int k = 0;
        while (ref != null && k < index - 1) {
            ref = ref.next;
            k++;
        }
        if (ref == null) return;
        ref.next = new Node(value, ref.next);
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public void remove(int index) {
        if (head == null) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        Node ref = head;
        int k = 0;
        while (ref.next != null && k < index - 1) {
            ref = ref.next;
            k++;
        }
        if (ref.next != null) {
            ref.next = ref.next.next;
        }
    }

    public void createHeadRec(int n) {
        Scanner scanner = new Scanner(System.in);
        head = null;
        createHeadRecInternal(n, scanner);
    }

    private void createHeadRecInternal(int n, Scanner scanner) {
        if (n == 0) return;
        System.out.print("Введите значение: ");
        int value = scanner.nextInt();
        head = new Node(value, head);
        createHeadRecInternal(n - 1, scanner);
    }

    public void createTailRec(int n) {
        Scanner scanner = new Scanner(System.in);
        head = createTailRecInternal(n, scanner);
    }

    private Node createTailRecInternal(int n, Scanner scanner) {
        if (n == 0) return null;
        System.out.print("Введите значение: ");
        int value = scanner.nextInt();
        return new Node(value, createTailRecInternal(n - 1, scanner));
    }

    public String toStringRec() {
        return toStringRecInternal(head);
    }

    private String toStringRecInternal(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecInternal(node.next);
    }
}