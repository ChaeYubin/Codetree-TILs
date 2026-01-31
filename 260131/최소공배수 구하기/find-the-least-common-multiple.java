import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static int findGCD(int n, int m) {
        int gcd = 0;

        for (int i = Math.min(n, m); i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
                break;
            }
        }
        
        return gcd;
    }

    public static int findLCM(int n, int m) {
        int gcd = findGCD(n, m);

        return gcd * (n / gcd) * (m / gcd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(findLCM(n, m));
    }
}