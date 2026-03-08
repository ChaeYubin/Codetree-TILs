import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            int x;

            switch (command) {
                case "add":
                    x = sc.nextInt();
                    set.add(x);
                    break;
                case "remove":
                    x = sc.nextInt();
                    set.remove(x);
                    break;
                case "find":
                    x = sc.nextInt();
                    System.out.println(set.contains(x) ? "true" : "false");
                    break;
                case "lower_bound":
                    x = sc.nextInt();
                    System.out.println(set.ceiling(x) == null ? "None" : set.ceiling(x));
                    break;
                case "upper_bound":
                    x = sc.nextInt();
                    System.out.println(set.higher(x) == null ? "None" : set.higher(x));
                    break;
                case "largest":
                    System.out.println(set.size() > 0 ? set.last() : "None");
                    break;
                case "smallest":
                    System.out.println(set.size() > 0 ? set.first() : "None");
                    break;
                default:
                    break;
            }
        }
    }
}