public class Example3 {
    public static void main(String[] args) {
        traceRecursion(1);
    }

    public static void traceRecursion(int x) {
        if (x >= 20) {
            return;
        }
        System.out.println("До рекурсии: " + x);
        traceRecursion(2 * x + 1);
        System.out.println("После рекурсии: " + x);
    }
}