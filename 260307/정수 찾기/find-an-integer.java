import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(set.contains(sc.nextInt()) ? 1 : 0);
        }
    }
}