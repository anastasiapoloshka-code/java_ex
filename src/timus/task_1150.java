import java.util.Scanner;

public class task_1150 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        in.close();

        long[] cnt = new long[10];

        for (long p = 1; p <= N; p *= 10) {
            long left = N / (p * 10);
            long cur = (N / p) % 10;
            long right = N % p;

            // считаем для всех цифр 0..9
            for (int d = 0; d <= 9; d++) {
                cnt[d] += left * p;

                if (cur > d) {
                    cnt[d] += p;
                } else if (cur == d) {
                    cnt[d] += right + 1;
                }
            }

            // убираем ведущие нули
            cnt[0] -= p;
        }

        // вывод от 0 до 9
        for (int d = 0; d <= 9; d++) {
            System.out.println(cnt[d]);
        }
    }
}
