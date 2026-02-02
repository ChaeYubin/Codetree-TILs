import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        // 내림차순 정렬
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());
        
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}