import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> diff = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                diff.add(Math.abs(arr[i] - arr[j]));
            }
        }

        // 차이가 M 이상이면서 제일 작은 경우 -> ceiling
        if (diff.ceiling(m) != null) {
            System.out.println(diff.ceiling(m));
        } else {
            System.out.println("-1");
        }
    }
}