public class Task7CreateFromTail {
    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node tail = head;

        for (int i = 1; i < 10; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }

        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}