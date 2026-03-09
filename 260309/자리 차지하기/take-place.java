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

        int result = 0;

        // 최선의 자리 선택: ai다 같거나 작은 최대 위치에 자리 배치를 하는 것
        for (int i = 0; i < n; i++) {
            if (seat.floor(arr[i]) != null) {
                int num = seat.floor(arr[i]);
                seat.remove(num);
                
                result++;
            } else {
                break;
            }
        }

        System.out.print(result);
    }
}