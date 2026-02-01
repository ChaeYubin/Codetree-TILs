import java.util.Scanner;
public class Main {
    public static int func(int n) {
        if (n <= 2) return n;

        return func(n / 3) + func(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(func(n));
    }
}