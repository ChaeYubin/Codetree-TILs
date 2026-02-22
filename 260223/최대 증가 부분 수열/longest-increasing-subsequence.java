import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
            
        // dp[i]: i번째 숫자를 마지막으로 하는 부분 수열의 최장 길이
        int[] dp = new int[n + 1];

        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int num : dp) {
            maxLen = Math.max(maxLen, num);
        }

        System.out.println(maxLen);
    }
}