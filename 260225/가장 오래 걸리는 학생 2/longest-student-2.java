import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.lang.Math;

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

        // 1~N-1: 학생, N: 학교 
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            graph.get(b).add(new Node(a, d));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // dist 기준 오름차순 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
        dist[n] = 0;
        pq.offer(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.dist) continue;

            for (Node nextNode : graph.get(curNode.to)) {
                int acc = dist[curNode.to] + nextNode.dist;

                if (dist[nextNode.to] > acc) {
                    dist[nextNode.to] = acc;
                    pq.offer(nextNode);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            result = Math.max(result, dist[i]);
        }

        System.out.println(result);
    }
}