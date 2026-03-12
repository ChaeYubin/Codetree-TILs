import java.util.Scanner;

public class Main {
    static class Stone {
        int group1, group2, group3;

        Stone(int group1, int group2, int group3) {
            this.group1 = group1;
            this.group2 = group2;
            this.group3 = group3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        Stone[] prefixStones = new Stone[n + 1];
        prefixStones[0] = new Stone(0, 0, 0);

        for (int i = 1; i <= n; i++) {
            Stone prev = prefixStones[i - 1];
            Stone newStone = new Stone(prev.group1, prev.group2, prev.group3);

            int group = sc.nextInt();
            if (group == 1) {
                newStone.group1++;
            } else if (group == 2) {
                newStone.group2++;
            } else {
                newStone.group3++;
            }

            prefixStones[i] = newStone;
        }   
        
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Stone s1 = prefixStones[a - 1];
            Stone s2 = prefixStones[b];

            System.out.println((s2.group1 - s1.group1) + " " + (s2.group2 - s1.group2) + " " + (s2.group3 - s1.group3));
        }
    }
}