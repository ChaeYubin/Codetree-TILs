import java.util.Scanner;
import java.util.TreeSet;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> seat = new TreeSet<>();
        for (int i = 1; i <= m; i++) {
            seat.add(i);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);  // 오름차순 정렬
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (seat.floor(arr[i]) != null) {
                result++;
                int num = seat.floor(arr[i]);
                seat.remove(num);
            }
        }

        System.out.print(result);
    }
}