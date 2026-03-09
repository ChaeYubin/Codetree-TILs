import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            // x보다 m 이상 더 크면서 가장 작은 값
            // r - x >= m을 만족하는 최소 r ==> r >= m + x를 만족하는 최소 r 구하기
            if (set.ceiling(m + x) != null) {
                answer = Math.min(answer, set.ceiling(m + x) - x);
            }

            // x보다 m 이상 더 작으면서 가장 큰 값
            // x - r >= m을 만족하는 최대 r ==> x - m >= r을 만족하는 최대 r 구하기
            if (set.floor(x - m) != null) {
                answer = Math.min(answer, set.floor(x - m) + m);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}