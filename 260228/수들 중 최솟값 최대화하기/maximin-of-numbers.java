import java.util.Scanner;

public class Main {
    static int n, max;
    static int[][] grid;
    static boolean[] colVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        max = 0;
        colVisited = new boolean[n];

        dfs(0, 10_001);

        System.out.println(max);
    }

    static void dfs(int row, int min) {
        if (row == n) {
            max = Math.max(max, min);
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colVisited[col]) continue;
            
            colVisited[col] = true;
            dfs(row + 1, Math.min(grid[row][col], min));
            colVisited[col] = false;
        }
    }
}