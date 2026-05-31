public class Example4Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(n + "! = " + factorial(n));
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}