import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task_1001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> numbers = new ArrayList<>();

        String line = br.readLine();
        if (line != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                long x = Long.parseLong(st.nextToken());
                numbers.add(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            double root = Math.sqrt(numbers.get(i));
            sb.append(String.format("%.4f", root)).append('\n');
        }

        System.out.print(sb.toString());
    }
}