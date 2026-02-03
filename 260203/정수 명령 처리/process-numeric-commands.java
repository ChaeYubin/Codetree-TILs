import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // 남은 줄바꿈 제거

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.equals("size")) {
                System.out.println(stack.size());

            } else if (command.equals("pop")) {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());

            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);

            } else if (command.equals("top")) {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());

            } else { // push X
                String[] parts = command.split(" ");
                int num = Integer.parseInt(parts[1]);
                stack.push(num);
            }
        }
    }
}