import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // 양방향 그래프 구성
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // 정점 A에서 정점 B까지의 최단 거리와 그때의 경로를 구하기
        int a = sc.nextInt();
        int b = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[a] = 0;
        pq.offer(new Node(a, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.dist) continue;

            for (Node nextNode : graph.get(curNode.to)) {
                int acc = dist[curNode.to] + nextNode.dist;

                if (dist[nextNode.to] > acc) {
                    dist[nextNode.to] = acc;
                    path[nextNode.to] = curNode.to;

                    pq.offer(nextNode);
                }
            }
        }

        // B에서 A로 거슬러가며 경로 확인
        int x = b;
        ArrayList<Integer> paths = new ArrayList<>();

        while (x != 0) {
            paths.add(x);
            if (x == a) break;
            x = path[x];
        }

        System.out.println(dist[b]);

        for (int i = paths.size() - 1; i >= 0; i--) {
            System.out.print(paths.get(i) + " ");
        }

    }
}