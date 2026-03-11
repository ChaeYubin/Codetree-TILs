import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(edges);
        int mstSum = 0;

        // 가중치가 작은 간선부터 선택
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                mstSum += edge.weight;
            }
        }
        
        System.out.println(mstSum);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra != rb) {
            parent[rb] = ra;
            return true;
        }

        return false;
    }
}