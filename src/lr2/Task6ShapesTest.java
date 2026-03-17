package lr2;

public class Task6ShapesTest {
    public static void main(String[] args) {
        Shape2D circle = new Circle(3.0);
        Shape2D square = new Square(4.0);
        Shape2D triangle = new Triangle(3.0, 4.0, 5.0);

        printShapeInfo("Круг", circle);
        printShapeInfo("Квадрат", square);
        printShapeInfo("Треугольник", triangle);
    }

    private static void printShapeInfo(String name, Shape2D shape) {
        System.out.println(name + ":");
        System.out.println("  Площадь = " + shape.area());
        System.out.println("  Периметр = " + shape.perimeter());
    }
}
