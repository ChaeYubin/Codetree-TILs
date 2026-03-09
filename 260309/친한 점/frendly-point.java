import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y; // 오름차순 정렬(x, y는 모두 양수)
            }

            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Pair> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            treeSet.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Pair result = treeSet.lower(new Pair(x, y));
            System.out.println(result == null ? "-1 -1" + result.x + " " + result.y);
        }
    }
}