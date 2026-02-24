import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (dp[i] == 0) continue;

            for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                dp[i + j] = dp[i] + 1;
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}