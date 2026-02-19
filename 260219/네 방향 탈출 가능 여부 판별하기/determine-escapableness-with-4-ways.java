import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        boolean[][] visited = new boolean[n][m];

        Queue<Position> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offer(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + DIR[i][0];
                int ny = cur.y + DIR[i][1];

                if (nx == n - 1 && ny == m - 1) {
                    System.out.println(1);
                    return;
                }

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny));
            }
        }

        System.out.println(0);
    }
}