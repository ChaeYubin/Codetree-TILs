import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            System.out.println(set.ceiling(num) == null ? -1 : set.ceiling(num));
        }
    }
}