package timus;

import java.util.Scanner;

public class Timus1197 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim()); // читаем строку с числом

        for (int i = 0; i < t; i++) {
            String pos = in.nextLine().trim();
            // если вдруг строка пустая, читаем ещё раз
            while (pos.isEmpty()) {
                pos = in.nextLine().trim();
            }

            int col = pos.charAt(0) - 'a' + 1; // a..h -> 1..8
            int row = pos.charAt(1) - '0';     // '1'..'8' -> 1..8

            int[][] moves = {
                    { 2,  1}, { 2, -1},
                    {-2,  1}, {-2, -1},
                    { 1,  2}, { 1, -2},
                    {-1,  2}, {-1, -2}
            };

            int count = 0;
            for (int[] m : moves) {
                int nc = col + m[0];
                int nr = row + m[1];
                if (nc >= 1 && nc <= 8 && nr >= 1 && nr <= 8) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}