import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task_2012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int f = Integer.parseInt(line.trim());

        // За оставшиеся 4 часа Гриша успеет решить не более 5 задач (240 / 45).
        if (f + 5 >= 12) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}