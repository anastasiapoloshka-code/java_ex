package lr2;

public class Task5RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5.0, 3.0);
        Rectangle r2 = new Rectangle(10.0, 2.5);

        r1.printInfo();
        r2.printInfo();

        r1.setLength(6.0);
        r1.setWidth(4.0);
        System.out.println("После изменения размеров:");
        r1.printInfo();
    }
}
