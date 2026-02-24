import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[i]: 첫 번째 위치에서 i번째 위치로 오기까지의 최대 점프 횟수
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[1] = 0;
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (dp[i] == -1) continue;

            for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                dp[i + j] = dp[i] + 1;
                result = dp[i + j];
            }
        }

        System.out.println(result);
    }
}