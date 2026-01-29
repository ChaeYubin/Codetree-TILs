import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] datePerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int day1 = d1;

        for (int i = 0; i < m1 - 1; i++) {
            day1 += datePerMonth[i];
        }

        int day2 = d2;

        for (int i = 0; i < m2 - 1; i++) {
            day2 += datePerMonth[i];
        }

        // 일수 차이 구하기
        int diff = day2 - day1;

        // day 인덱스로 mod 연산하기
        System.out.println(day[Math.floorMod(diff, 7)]);
    }
}