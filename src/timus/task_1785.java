import java.util.Scanner;

public class task_1785 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        String result;
        if (n >= 1 && n <= 4) {
            result = "few";
        } else if (n <= 9) {
            result = "several";
        } else if (n <= 19) {
            result = "pack";
        } else if (n <= 49) {
            result = "lots";
        } else if (n <= 99) {
            result = "horde";
        } else if (n <= 249) {
            result = "throng";
        } else if (n <= 499) {
            result = "swarm";
        } else if (n <= 999) {
            result = "zounds";
        } else {
            result = "legion";
        }

        System.out.println(result);
    }
}
