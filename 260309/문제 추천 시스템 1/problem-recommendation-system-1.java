import java.util.Scanner; 
import java.util.TreeSet;

public class Main {
    static class Problem implements Comparable<Problem> {
        int number, difficulty;

        Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty == o.difficulty) return this.number - o.number;
            return this.difficulty - o.difficulty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Problem> problems = new TreeSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            problems.add(new Problem(p, l));
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String command = sc.next();

            if (command.equals("rc")) {
                int x = sc.nextInt();

                System.out.println(x == 1 ? problems.last().number : problems.first().number);
            } else if (command.equals("ad") || command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                if (command.equals("ad")) {
                    problems.add(new Problem(p, l));
                } else {
                    problems.remove(new Problem(p, l));
                }
            }
        }
    }
}