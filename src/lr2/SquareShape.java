package lr2;

public class SquareShape extends BaseShape {
    private double side;

    public SquareShape(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}
