import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static int gcd(int n, int m) {
        for (int i = Math.max(n, m); i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(gcd(n, m));
    }
}