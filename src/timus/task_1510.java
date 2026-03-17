import java.util.Scanner;

public class task_1510 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long candidate = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            if (count == 0) {
                candidate = x;
                count = 1;
            } else if (x == candidate) {
                count++;
            } else {
                count--;
            }
        }

        System.out.println(candidate);
    }
}
