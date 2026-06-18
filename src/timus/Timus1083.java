package timus;

import java.util.Scanner;

public class Timus1083 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // число n
        String excls = in.next(); // строка из k восклицательных знаков
        int k = excls.length(); // количество восклицательных знаков

        int result = 1;
        // Перемножаем n, n-k, n-2k, ... пока значение положительное
        for (int x = n; x > 0; x -= k) {
            result *= x;
        }

        System.out.println(result);
    }
}