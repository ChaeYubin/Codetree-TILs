import java.util.Scanner;
public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static boolean canEscape;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        canEscape = false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(canEscape ? 1 : 0);
    }

    static void dfs(int x, int y) {
        if (canEscape) return;

        if (x == n - 1 && y == m - 1) {
            canEscape = true;
            return;
        }

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || grid[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}