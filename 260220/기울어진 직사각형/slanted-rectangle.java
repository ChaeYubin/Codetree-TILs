import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.Math;

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
                // 시작점: (i, j)

                for (int a = 1; a < N - 1; a++) {
                    for (int b = 1; b < N - 1; b++) {
                        // a, b: 변의 길이
                        if (isPossible(i, j, a, b)) {
                            max = Math.max(max, calculateMax(i, j, a, b));
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    static int calculateMax(int x, int y, int len1, int len2) {
        int sum = grid[x][y];

        for (int i = 0; i < 4; i++) {
            int len = (i % 2) == 0 ? len1 : len2;

            for (int j = 0; j < len; j++) {
                x += DIR[i][0];
                y += DIR[i][1];

                sum += grid[x][y];
            }
        }

        sum -= grid[x][y];  // 시작점 두 번 더해지는거 보정 

        return sum;
    }

    static boolean isPossible(int x, int y, int len1, int len2) {
        // 경계값 확인
        for (int i = 0; i < 3; i++) {
            int len = (i % 2) == 0 ? len1 : len2;

            x += DIR[i][0] * len;
            y += DIR[i][1] * len;

            if (x < 0 || x >= N || y < 0 || y >= N) return false;
        }

        return true;
    }

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
