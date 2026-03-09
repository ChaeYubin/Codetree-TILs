import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Pair> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            Pair removed = set.ceiling(new Pair(num, 0));

            if (removed == null) {
                System.out.println("-1 -1");
            } else {
                System.out.println(removed.x + " " + removed.y);
                set.remove(removed);
            }
        }
    }
}