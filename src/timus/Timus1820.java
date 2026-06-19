package timus;

import java.util.Scanner;

public class Timus1820 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // количество стейков
        int k = in.nextInt(); // сколько стейков помещается на сковородку одновременно

        int result;
        if (n <= k) {
            result = 2; // один или несколько стейков умещаются сразу, нужно 2 минуты на две стороны
        } else {
            // Общее число сторон = 2 * n, за минуту можно прожарить k сторон
            result = (2 * n + k - 1) / k; // целочисленный ceil
        }

        System.out.println(result);
    }
}