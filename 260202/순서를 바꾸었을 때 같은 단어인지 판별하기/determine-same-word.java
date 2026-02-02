import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();

        if (word1.length() != word2.length()) {
            System.out.println("No");
            return;
        }

        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();

        Arrays.sort(words1);
        Arrays.sort(words2);

        for (int i = 0; i < words1.length; i++) {
            if (words1[i] != words2[i]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}