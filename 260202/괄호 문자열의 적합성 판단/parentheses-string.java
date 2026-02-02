import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}