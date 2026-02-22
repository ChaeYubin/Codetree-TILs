import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];

        // 초기값 설정
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(matrix[0][i], dp[0][i - 1]);
            dp[i][0] = Math.max(matrix[i][0], dp[i - 1][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // 위에서 오는 경우와 왼쪽에서 오는 경우
                // 두 가지의 경로의 최댓값 중에서 최솟값 선택
                int fromUp = Math.max(dp[i - 1][j], matrix[i][j]);
                int fromLeft = Math.max(dp[i][j - 1], matrix[i][j]);

                dp[i][j] = Math.min(fromUp, fromLeft);
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}