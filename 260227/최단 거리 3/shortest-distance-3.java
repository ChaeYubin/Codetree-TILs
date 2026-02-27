import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
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

    static int n, m;
    static int[] dist;
    static HashSet<Edge>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();  // 정점 개수 (정점: 1~N)
        m = sc.nextInt();  // 간선 개수

        // HashSet도 가능할듯 (인덱스 접근 없어서)
        graph = new HashSet[n + 1];  
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // 양방향 그래프 구성
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        dijkstra(a);

        System.out.println(dist[b]);
    }

    static void dijkstra(int a) {
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));

        dist[a] = 0;
        pq.offer(new State(a, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (dist[cur.node] < cur.dist) continue;

            for (Edge edge : graph[cur.node]) {
                int newDist = cur.dist + edge.dist;

                if (dist[edge.to] > newDist) {
                    dist[edge.to] = newDist;

                    pq.offer(new State(edge.to, newDist));
                }
            }
        }
    }
}