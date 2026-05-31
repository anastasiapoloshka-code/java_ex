public class Node {
    public int value;   // значение элемента
    public Node next;   // ссылка на следующий узел

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}