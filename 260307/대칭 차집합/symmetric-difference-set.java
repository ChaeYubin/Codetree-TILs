import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<Integer> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(sc.nextInt());
        }

        HashSet<Integer> setB = new HashSet<>();
        for (int i = 0; i < m; i++) {
            setB.add(sc.nextInt());
        }

        HashSet<Integer> setAminusB = new HashSet<>(setA);
        HashSet<Integer> setBminusA = new HashSet<>(setB);

        for (int num : setA) {
            if (setB.contains(num)) setAminusB.remove(num);
        }

        for (int num : setB) {
            if (setA.contains(num)) setBminusA.remove(num);
        }

        for (int num : setBminusA) {
            setAminusB.add(num);
        }

        System.out.println(setAminusB.size());
    }
}