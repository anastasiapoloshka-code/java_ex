import java.util.*;

public class task_1203 {
    static class Talk {
        int start;
        int end;

        Talk(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Talk[] talks = new Talk[n];

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            talks[i] = new Talk(s, e);
        }

        Arrays.sort(talks, new Comparator<Talk>() {
            @Override
            public int compare(Talk a, Talk b) {
                if (a.end != b.end) return a.end - b.end;
                return a.start - b.start;
            }
        });

        int count = 0;
        int lastEnd = -1;

        for (Talk t : talks) {
            if (count == 0 || t.start >= lastEnd + 1) {
                count++;
                lastEnd = t.end;
            }
        }

        System.out.println(count);
    }
}
