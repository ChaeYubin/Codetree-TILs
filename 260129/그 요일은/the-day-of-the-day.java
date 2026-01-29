import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.

        int[] datePerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int day1 = d1;

        for (int i = 0; i < m1 - 1; i++) {
            day1 += datePerMonth[i];
        }

        int day2 = d2;

        for (int i = 0; i < m2 - 1; i++) {
            day2 += datePerMonth[i];
        }

        int diff = day2 - day1;

        // System.out.println(String.format("day1: %d, day2: %d, diff: %d", day1, day2, diff));

        int dayIndex = 0;

        for (int i = 0; i < day.length; i++) {
            if (A.equals(day[i])) {
                dayIndex = i;
                break;
            }
        }

        int num = diff / 7; 
        int plus = (diff % 7) >= dayIndex ? 1 : 0;  

        System.out.println(num + plus);
    }
}