import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] datePerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day1 = 0;
        int day2 = 0;

        for (int i = 0; i < m1 - 1; i++) {
            day1 += datePerMonth[i];
        }

        day1 += d1;

        for (int i = 0; i < m2 - 1; i++) {
            day2 += datePerMonth[i];
        }

        day2 += d2;

        System.out.println(day2 - day1 + 1);
    }
}