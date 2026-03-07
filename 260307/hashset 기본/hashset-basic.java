import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            int x = sc.nextInt();

            if (command.contains("add")) {
                if (set.contains(x)) continue;
                set.add(x);
            } else if (command.contains("remove")) {
                set.remove(x);
            } else {
                System.out.println(set.contains(x) ? "true" : "false");
            }
        }
    }
}