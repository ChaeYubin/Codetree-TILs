import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int result = 0;

        int i = coins.length - 1;
        while (k > 0) {
            if (k >= coins[i]) {
                k -= coins[i];
                result++;
            } else {
                i--;
            }
        }

        System.out.println(result);
    }
}