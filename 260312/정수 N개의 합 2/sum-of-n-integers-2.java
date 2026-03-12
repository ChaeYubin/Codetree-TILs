import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + sc.nextInt();
        }

        int maxSum = 0;
        for (int i = k; i < n + 1; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - k]);
        }

        System.out.println(maxSum);
    }
}