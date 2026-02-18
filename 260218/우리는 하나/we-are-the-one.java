import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n, k, u, d;
    static int[][] grid;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][]  visited;
    static int maxCity;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        n = nextInt();
        k = nextInt();
        u = nextInt();
        d = nextInt();

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextInt();
            }
        }

        visited = new boolean[n][n];

        selectCity(0, 0, new int[k][2]);  // k개 도시 고르기

        System.out.println(maxCity);

    }

    static void checkNearCity(int[][] selectedCity) {
        int city = k;
        queue.clear();
        visited = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            visited[selectedCity[i][0]][selectedCity[i][1]] = true;
            queue.add(selectedCity[i]);
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curHeight = grid[cur[0]][cur[1]];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

                int nextHeight = grid[nx][ny];
                int diff = Math.abs(curHeight - nextHeight);

                if (diff >= u && diff <= d) {
                    city++;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        maxCity = Math.max(maxCity, city);
    }

    static void selectCity(int start, int count, int[][] selectedCity) {
        if (count == k) {
            // k개 도시에서 갈 수 있는 서로 다른 도시의 수 확인하기
            checkNearCity(selectedCity);
            return;
        }

        for (int index = start; index < n*n; index++) {
            int x = index / n;
            int y = index % n;

            selectedCity[count] = new int[]{x, y};

            selectCity(index + 1, count + 1, selectedCity);
        }
    }

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
