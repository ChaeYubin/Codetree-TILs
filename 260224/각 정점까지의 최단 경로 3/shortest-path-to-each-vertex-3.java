import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u][v] = w;  // 단방향 그래프
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        dist[1] = 0;

        for (int i = 1; i <= n; i++) {
            // 아직 방문하지 않은 정점 중 dist 값이 가장 작은 정점 찾기
            int minIndex = -1;

            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            // 최솟값에 해당하는 정점에 방문 표시
            visited[minIndex] = true;

            // 최솟값에 해당하는 정점에 연결된 간선들을 보며
            // 시작점으로부터의 최단거리 값 갱신
            for (int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우 스킵
                if (graph[minIndex][j] == 0) continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
    }
}