public class Task8LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Список: " + list);

        list.insert(2, 99);
        System.out.println("После вставки: " + list);

        list.removeFirst();
        System.out.println("После removeFirst: " + list);

        list.removeLast();
        System.out.println("После removeLast: " + list);

        list.remove(2);
        System.out.println("После remove(2): " + list);
    }
}