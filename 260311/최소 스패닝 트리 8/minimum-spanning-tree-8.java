import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // prim
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n + 1];  // dist[v]: 현재 MST와 v를 연결하는 가장 작은 간선 가중치
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];

        // 임의의 한 점에서 시작
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        int mstSum = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();  // MST에 추가
            int u = cur.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            mstSum += cur.dist;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int alt = edge.weight;

                if (visited[v]) continue;

                if (!visited[v] && alt < dist[v]) {
                    dist[v] = alt;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        System.out.println(mstSum);
    }
}