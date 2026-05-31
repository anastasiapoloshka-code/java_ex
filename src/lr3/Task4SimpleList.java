public class Task4SimpleList {
    public static void main(String[] args) {
        // 1. Создаём независимые узлы со значениями 0, 1, 2, 3
        Node n0 = new Node(0, null);
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);

        // 2. Связываем узлы в односвязный список: n0 -> n1 -> n2 -> n3
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;

        // 3. Переменная ref указывает на голову списка
        Node ref = n0;

        // 4. Проходим по списку и выводим значения всех узлов
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}