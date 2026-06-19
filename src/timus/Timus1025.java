package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Timus1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine().trim());

        int[] groups = new int[k];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(reader.readLine());
            }
            groups[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(groups);

        int needGroups = k / 2 + 1;
        int supporters = 0;

        for (int i = 0; i < needGroups; i++) {
            supporters += (groups[i] / 2) + 1;
        }

        System.out.println(supporters);
    }
}