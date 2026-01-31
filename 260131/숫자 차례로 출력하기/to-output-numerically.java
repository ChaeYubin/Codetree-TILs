import java.util.Scanner;
public class Main {
    public static void recursion1(int n) {
        if (n == 0) return;

        recursion1(n - 1); 
        System.out.print(n + " ");
    }

    public static void recursion2(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        recursion2(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        recursion1(n);
        System.out.println();
        recursion2(n);
    }
}