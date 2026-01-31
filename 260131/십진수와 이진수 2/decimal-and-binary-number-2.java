import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.

        // 2진수 -> 10진수 변환
        int num = 0;

        for (char s : binary.toCharArray()) {
            num = num * 2 + (s - '0');
        }

        // 17배 후 다시 2진수로 변환 
        num *= 17;

        String result = "";

        while (num > 0) {
            result += num % 2;
            num /= 2;
        }

        StringBuilder sb = new StringBuilder(result);
        System.out.println(sb.reverse());
    }
}