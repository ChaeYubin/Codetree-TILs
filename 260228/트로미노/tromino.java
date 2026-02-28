import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxSum = 0;

        // 1+2 -> 4가지 경우
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i + 1][j] + grid[i + 1][j + 1]);
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j + 1] + grid[i + 1][j]);
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j + 1] + grid[i + 1][j + 1]);
                maxSum = Math.max(maxSum, grid[i][j + 1] + grid[i + 1][j] + grid[i + 1][j + 1]);
            }
        }

        // 3 -> 2가지 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i][j + 1] + grid[i][j + 2]);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m; j++) {
                maxSum = Math.max(maxSum, grid[i][j] + grid[i + 1][j] + grid[i + 2][j]);
            }
        }

        System.out.println(maxSum);
    }
}