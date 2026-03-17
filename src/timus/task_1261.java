import java.util.Scanner;

public class task_1261 {
    static boolean isTernaryBinary(long x) {
        while (x > 0) {
            long digit = x % 3;
            if (digit > 1) {
                return false;
            }
            x /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        in.close();

        final long LIMIT = 4294967291L;
        long answerS = 0;
        long answerT = 0;

        // простой поиск подходящих чаевых
        for (long T = 1; T <= LIMIT - N; T++) {
            if (!isTernaryBinary(T)) {
                continue;
            }
            long S = N + T;
            if (S > LIMIT) {
                break;
            }
            if (isTernaryBinary(S)) {
                answerS = S;
                answerT = T;
                break;
            }
        }

        if (answerS == 0) {
            System.out.println(0);
        } else {
            System.out.println(answerS + " " + answerT);
        }
    }
}
