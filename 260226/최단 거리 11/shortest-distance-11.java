import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = MAX_INT;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        dist[b] = 0;
        pq.offer(new State(b, 0));

        // 도착점(b)을 시작점으로 하는 다익스트라 진행
        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (dist[cur.node] < cur.dist) continue;

            for (Edge edge : graph[cur.node]) {
                int next = edge.to;
                int newDist = cur.dist + edge.dist;

                if (dist[next] > newDist) {
                    dist[next] = newDist;

                    pq.offer(new State(next, newDist));
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        int x = a;
        path.add(x);

        while (x != b) {
            int nextNode = -1;

            for (Edge edge : graph[x]) {
                int next = edge.to;

                if (dist[next] + edge.dist == dist[x]) {
                    if (nextNode == -1 || next < nextNode) {
                        nextNode = next;
                    }
                }
            }

            x = nextNode;
            path.add(x);
        }

        System.out.println(dist[a]);

        for (int num : path) {
            System.out.print(num + " ");
        }
    }
}