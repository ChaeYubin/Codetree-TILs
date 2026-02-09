import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;
import java.lang.Math;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; 
    static int maxGold = 0;

    public static void mining(int x, int y) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        visited[x][y] = true;
        queue.offer(new Integer[] {x, y});
        
        int gold = 0;

        for (int k = 0; k <= N - 1; k++) {
            int size = queue.size();

            // 한 라운드씩 처리
            while (--size >= 0) {
                Integer[] current = queue.poll();
                if (map[current[0]][current[1]] == 1) gold++;

                // 상하좌우 탐색, 방문하지 않았다면 큐에 add
                for (int d = 0; d < 4; d++) {
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Integer[] {nx, ny});
                }
            }
            
            // 채굴에 드는 비용 계산, 금 개수 최댓값 갱신
            int cost = (k * k) + ((k + 1) * (k + 1));
            if (gold * M > cost) {
                maxGold = Math.max(maxGold, gold);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mining(i, j);
            }
        }

        System.out.println(maxGold);
    }
}