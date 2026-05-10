public class Example5Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("fib(" + n + ") = " + fib(n));

        System.out.println("\nОбход дерева рекурсивных вызовов:");
        traceFib(n, 0);
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void traceFib(int n, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("fib(" + n + ")");

        if (n == 0 || n == 1) {
            return;
        }

        traceFib(n - 1, level + 1);
        traceFib(n - 2, level + 1);
    }
}