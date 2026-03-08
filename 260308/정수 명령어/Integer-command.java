import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            TreeSet<Integer> set = new TreeSet<>();

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                char command = sc.next().charAt(0);
                int num = sc.nextInt();

                switch (command) {
                    case 'I':
                        set.add(num);
                        break;
                    case 'D':
                        if (num == 1) {
                            // 최댓값 삭제
                            if (set.isEmpty()) break;
                            int max = set.last();
                            set.remove(max);
                        } else {
                            // 최솟값 삭제
                            if (set.isEmpty()) break;
                            int min = set.first();
                            set.remove(min);
                        }
                    default:
                        break;
                }
            }

            System.out.println(set.isEmpty() ? "EMPTY" : set.last() + " " + set.first());
        }
    }
}