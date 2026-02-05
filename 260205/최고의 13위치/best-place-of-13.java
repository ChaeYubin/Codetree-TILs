import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int count = 0;

                for (int k = 0; k < 3; k++) {
                    if (grid[i][j + k] == 1) {
                        count++;
                    }
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.print(maxCount);
    }
}