import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            // max: 지나온 수들까지의 합
            if (max < 0) {
                max = 0;
            } 
            
            max += a[i];
        }

        System.out.println(max);
    }
}