import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static class Person {
        String name;
        int height;
        int weight;

        public Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] arr = new Person[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Person(sc.next(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr, (p1, p2) -> p1.height - p2.height);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].name + " " + arr[i].height + " " + arr[i].weight);
        }
    }
}