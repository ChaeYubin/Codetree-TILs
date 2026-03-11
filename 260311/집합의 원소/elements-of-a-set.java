import java.util.Scanner;

public class Main {
    static int[] uf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        uf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int qType = sc.nextInt();

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (qType == 0) {
                union(a, b);
            } else {
                System.out.println(find(a) == find(b) ? 1 : 0);
            }
        }
    }

    static int find(int x) {
        if (uf[x] == x) return x;

        return uf[x] = find(uf[x]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra != rb) {
            uf[b] = ra;
        }
    }
}