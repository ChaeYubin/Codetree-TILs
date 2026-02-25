import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.Arrays;

public class Main {
    static int MAX_INT = (int) 1e9;

    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node v) {
            return this.cost - v.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>();
        cost[k] = 0;
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            // cost가 가장 적은 노드 선택(방문할 노드 꺼내기)
            // curNode.to: 방문할 노드
            Node curNode = pq.poll();  

            // curNode의 비용이 이미 기록되어 있는 cost 값보다 크다면 skip (중복 방문 방지)
            if (cost[curNode.to] < curNode.cost) {
                continue;
			}

            // 현재까지의 비용 + 다음 방문에 필요한 비용을
            // 기존에 저장된 값과 비교해서 갱신 
            for (Node nextNode : graph.get(curNode.to)) {
                int cost = cost[curNode.to] + nextNode.cost;

                if (cost[nextNode.to] > cost) {
                    cost[nextNode.to] = cost;
                    // 최단 경로가 되는 노드는 큐에 추가
                    pq.offer(nextNode);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.println(cost[i] == Integer.MAX_VALUE ? -1 : cost[i]);
        }

    }
}