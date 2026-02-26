import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    final static int MAX_INT = Integer.MAX_VALUE;

    static class Edge {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static class State {
        int node, dist;

        public State(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = MAX_INT;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // 무방향 그래프 구성
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        dist[k] = 0;
        pq.offer(new State(k, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (dist[cur.node] < cur.dist) continue;

            for (Edge edge : graph[cur.node]) {
                int next = edge.to;
                
                if (dist[next] > cur.dist + edge.dist) {
                    dist[next] = cur.dist + edge.dist;

                    pq.offer(new State(next, cur.dist + edge.dist));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i] == MAX_INT ? -1 : dist[i]);
        }
    }
}