package lr2;

public class Task8ShapesInheritanceTest {
    public static void main(String[] args) {
        BaseShape circle = new CircleShape(2.0);
        BaseShape square = new SquareShape(3.0);
        BaseShape triangle = new TriangleShape(3.0, 4.0, 5.0);

        printShape("Круг (наследование)", circle);
        printShape("Квадрат (наследование)", square);
        printShape("Треугольник (наследование)", triangle);
    }

    private static void printShape(String name, BaseShape shape) {
        System.out.println(name + ":");
        System.out.println("  Площадь = " + shape.area());
        System.out.println("  Периметр = " + shape.perimeter());
    }
}
