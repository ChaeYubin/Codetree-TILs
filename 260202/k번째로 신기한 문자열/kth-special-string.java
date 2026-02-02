import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String[] startWithTWords = Arrays.stream(words).filter(w -> w.contains(t)).toArray(String[]::new);

        Arrays.sort(startWithTWords);

        System.out.println(startWithTWords[k - 1]);
    }
}