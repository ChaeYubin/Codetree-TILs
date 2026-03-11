import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Edge {
        int to, weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
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

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n + 1];
        
        // 시작 정점 1번으로 설정
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        int mstSum = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int vertex = cur.vertex;

            if (visited[vertex]) continue;
            visited[vertex] = true;
            
            mstSum += cur.dist;

            for (Edge edge : graph.get(vertex)) {
                int next = edge.to;

                if (visited[next]) continue;

                if (dist[next] > edge.weight) {
                    dist[next] = edge.weight;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }

        System.out.println(mstSum);
    }
}