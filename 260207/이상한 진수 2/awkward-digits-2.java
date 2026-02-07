import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] str = a.toCharArray();
        int result = 0;

        for (int i = 0; i < str.length; i++) {
            char original = str[i];

            str[i] = (str[i] == '0') ? '1' : '0';
            result = Math.max(result, Integer.parseInt(new String(str), 2));

            str[i] = original; // 원상복구
        }

        System.out.println(result);
    }
}