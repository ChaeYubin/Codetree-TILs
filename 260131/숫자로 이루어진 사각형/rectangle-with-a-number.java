import java.util.Scanner;
public class Main {
    public static void printNumberSquare(int n) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int numberIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(numbers[numberIndex] + " ");
                numberIndex = (numberIndex + 1) % 9;
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printNumberSquare(n);
    }
}