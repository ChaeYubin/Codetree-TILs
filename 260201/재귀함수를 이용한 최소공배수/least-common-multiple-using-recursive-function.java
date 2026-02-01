import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static int GCD(int a, int b) {
        int gcd = 0;

        for (int n = Math.min(a, b); n > 0; n--) {
            if (a % n == 0 && b % n == 0) {
                gcd = n;
                break;
            }
        }

        return gcd;
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public static int getLCM(int n, int[] arr) {
        if (n == 2) return LCM(arr[0], arr[1]);

        int[] temp = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            temp[i] = arr[i];
        }

        return LCM(getLCM(n - 1, temp), arr[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(getLCM(n, arr));
    }
}