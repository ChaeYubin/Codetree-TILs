import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            set.add(num);

            if (set.size() == 2) {
                minDiff = Math.abs(set.first() - set.last());
            } else {
                if (set.lower(num) != null) {
                    minDiff = Math.min(minDiff, Math.abs(num - set.lower(num)));
                }

                if (set.higher(num) != null) {
                    minDiff = Math.min(minDiff, Math.abs(num - set.higher(num)));
                }
                
            }

            System.out.println(minDiff);
        }
    }
}