import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                sum += Math.abs(i - j) * a[j];
            }

            minSum = Math.min(minSum, sum);
        }

        System.out.print(minSum);
    }
}