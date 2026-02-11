import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum < 0) {
                sum = 0;
            } 
            
            sum += a[i];

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}