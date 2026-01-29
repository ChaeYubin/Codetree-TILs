import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] bits = new int[20];
        
        int index = 0;  // bits index 추적

        while (n > 1) {
            bits[index++] = n % 2;
            n /= 2;
        }

        bits[index] = n;

        String result = "";

        for (int i = index; i >= 0; i--) {
            result += bits[i];
        }

        System.out.println(result);
    }
}