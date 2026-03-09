import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
            
            int minDiff = Integer.MAX_VALUE;

            for (int num : set) {
                Integer num2 = set.higher(num);

                if (num2 != null) {
                    minDiff = Math.min(minDiff, Math.abs(num - num2));
                }
            }

            System.out.println(minDiff);
        }
    }
}