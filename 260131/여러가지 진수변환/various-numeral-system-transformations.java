import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        String temp = "";

        while (n > 0) {
            temp += n % b;
            n = n / b;
        }

        String result = "";

        for (int i = temp.length() - 1; i >= 0; i--) {
            result += temp.charAt(i);
        }

        System.out.println(result);
    }
}