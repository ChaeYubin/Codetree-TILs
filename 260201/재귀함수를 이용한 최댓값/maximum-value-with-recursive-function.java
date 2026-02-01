import java.util.Scanner;

public class Main {
    public static int findMaxValue(int n, int[] arr) {
        // 배열에 원소가 하나 뿐이라면 그 값 리턴
        if (n == 1) return arr[n - 1];

        // arr[0] ~ arr[n-1] 중에서 가장 큰 값과 arr[n] 비교
        int[] temp = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            temp[i] = arr[i];
        }

        int value = findMaxValue(n - 1, temp);

        return value < arr[n - 1] ? arr[n - 1] : value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMaxValue(n, arr));
    }
}