import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String result = "";

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            result += queue.poll() + " ";
        }

        System.out.print(result);
    }
}