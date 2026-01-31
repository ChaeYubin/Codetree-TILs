import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        // Please write your code here.

        // A진수 -> 10진수
        int num = 0;
        
        for (char c : N.toCharArray()) {
            num = num * A + (c - '0');
        }

        // 10진수 -> B진수
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(num % B);
            num /= B;
        }

        System.out.println(sb.reverse());
    }
}