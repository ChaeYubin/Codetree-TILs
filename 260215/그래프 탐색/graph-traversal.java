import java.util.Scanner;
public class Main {
    static int n, answer;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n + 1];
        answer = 0;

        visited[1] = true;
        dfs(1);

        System.out.println(answer);
    }

    static void dfs(int cur) {
        for (int i = 1; i <= n; i++) {
            if (graph[cur][i] == 1) {
                if (visited[i]) continue;

                visited[i] = true;
                answer++;
                dfs(i);
            }
        }
    }
}