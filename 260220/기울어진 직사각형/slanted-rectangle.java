import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);

    final static int[][] DIR = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    static int N;
    static int[][] grid;
    static int max;

    public static void main(String[] args) throws Exception {
        N = nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = nextInt();
            }
        }

        max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, i, j, 0, grid[i][j], 0);
            }
        }

        System.out.println(max);
    }

    static void dfs(int startX, int startY, int curX, int curY, int prevD, int sum, int count) {
        for (int i = prevD; i < 4; i++) {
            int nx = curX + DIR[prevD][0];
            int ny = curY + DIR[prevD][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            // 원점으로 돌아온 경우
            if (nx == startX && ny == startY && count > 2) {
                max = Math.max(max, sum);
                return;
            }

            dfs(startX, startY, nx, ny, i, sum + grid[nx][ny], count + 1);
        }
    }

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
