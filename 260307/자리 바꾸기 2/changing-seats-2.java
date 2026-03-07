import java.util.Scanner;
import java.util.HashSet;

public class Main {
    static HashSet<Integer>[] seatCount;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        seatCount = new HashSet[n + 1];
        for (int i = 0; i <= n; i++){
            seatCount[i] = new HashSet<>();
        }

        arr = new int[n + 1];  // 앉아있는 상태
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            seatCount[i].add(i);
        }

        int[] a = new int[k];
        int[] b = new int[k];

        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < k; j++) {
                swap(a[j], b[j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(seatCount[i].size());
        }
    }

    static void swap(int a, int b) {
        seatCount[arr[a]].add(b);
        seatCount[arr[b]].add(a);

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}