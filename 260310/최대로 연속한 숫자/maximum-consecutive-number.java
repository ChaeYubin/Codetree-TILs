import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n);  // 0과 n은 시작과 끝 경계

        for (int i = 0; i < m; i++) {
            int removed = sc.nextInt();
            int maxLen = 0;

            if (set.lower(removed) != null) {
                int lower = set.lower(removed);
                maxLen = Math.max(maxLen, removed - lower);
            }

            if (set.higher(removed) != null) {
                int higher = set.higher(removed);
                maxLen = Math.max(maxLen, higher - removed);
            }

            System.out.println(maxLen);
            set.add(removed);
        }
    }
}