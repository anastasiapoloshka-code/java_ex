package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Timus1014 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        long n = Long.parseLong(line.trim());

        if (n == 0) {
            System.out.println(10);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] digits = new int[20];
        int count = 0;

        for (int d = 9; d >= 2; d--) {
            while (n % d == 0) {
                digits[count++] = d;
                n /= d;
            }
        }

        if (n != 1) {
            System.out.println(-1);
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = count - 1; i >= 0; i--) {
            result.append(digits[i]);
        }

        System.out.println(result);
    }
}