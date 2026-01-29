import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.

        // 11월 1일에서 시작하기
        int time1 = dayToMinutes(11) + hourToMinutes(11) + 11;
        int time2 = dayToMinutes(A) + hourToMinutes(B) + C;

        System.out.println(time2 - time1 < 0 ? -1 : time2 - time1);
    }

    public static int dayToMinutes(int day) {
        return day * 24 * 60;
    }

    public static int hourToMinutes(int hour) {
        return hour * 60;
    }
}