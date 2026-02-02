import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, nums[i] + nums[2 * n - i - 1]);
        }

        System.out.println(result);
    }
}