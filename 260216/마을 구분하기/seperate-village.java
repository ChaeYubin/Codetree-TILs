import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int[][] grid;
    static int villageCount;
    static int peopleCount;
    static ArrayList<Integer> people;
    final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        villageCount = 0;
        people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    villageCount++;
                    peopleCount = 0;

                    grid[i][j] = 0;
                    dfs(i, j);

                    people.add(peopleCount);
                }
            }
        }

        System.out.println(villageCount);

        Collections.sort(people);
        for (int num : people) {
            System.out.println(num);
        }
    }

    static void dfs(int x, int y) {
        peopleCount++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if (grid[nx][ny] == 1) {
                grid[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}