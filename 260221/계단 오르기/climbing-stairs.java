import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // dp[i]: i층 높이에 올라오는 서로 다른 방법의 수
        // => (i - 2)층에서 2계단을 올라오는 경우 + (i - 3)층에서 3계단을 올라오는 경우
        int[] dp = new int[1001];

        // 초기값 설정
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }

        System.out.println(dp[n]);
    }
}