import java.util.Scanner;

public class Main {
    public static int sum(int n) {
        if (n <= 2) return n;

        return sum(n - 2) + n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(sum(n));
    }
}