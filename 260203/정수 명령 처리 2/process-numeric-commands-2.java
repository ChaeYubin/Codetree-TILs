import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine().trim();

            if (command.equals("pop")) {
                System.out.println(queue.poll());
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                System.out.println(queue.peek());
            } else {
                int num = Integer.parseInt(command.split(" ")[1]);
                queue.add(num);
            }
        }
    }
}