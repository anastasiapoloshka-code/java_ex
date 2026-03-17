package timus;

import java.util.Scanner;

public class task_1068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long sum;

        if (N > 0) {
            sum = (long) N * (N + 1) / 2;
        } else if (N == 0) {
            sum = 0;
        } else {
            int k = -N;
            sum = 1L - (long) k * (k + 1) / 2;
        }

        System.out.println(sum);
    }
}
