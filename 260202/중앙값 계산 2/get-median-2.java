import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            arr[i] = num;

            // 홀수 번째의 입력 -> 인덱스는 짝수
            if (i % 2 == 0) {
                Integer[] temp = new Integer[i + 1];
                
                for (int j = 0; j < i + 1; j++) {
                    temp[j] = arr[j];
                }

                Arrays.sort(temp);
                
                if (i == 0) {
                    System.out.print(temp[0] + " ");
                } else {
                    System.out.print(temp[i / 2] + " ");
                }
            }
        }
    }
}