import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.

        int result = 0;

        for (char num : binary.toCharArray()) {
            int n = num - '0';

            result = result * 2 + n;
        }

        System.out.println(result);
    }
}