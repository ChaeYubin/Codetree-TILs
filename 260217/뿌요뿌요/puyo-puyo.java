import java.util.Scanner;

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int[][] grid;
    static int poppedBlock;
    static int maxBlockSize;
    static int blockCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        poppedBlock = 0;
        maxBlockSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    blockCount = 0;

                    int firstValue = grid[i][j];
                    grid[i][j] = 0;
                    
                    dfs(i, j, firstValue);

                    if (blockCount >= 4) {
                        poppedBlock++;
                    }

                    if (maxBlockSize < blockCount) {
                        maxBlockSize = blockCount;
                    }
                }
            }
        }

        System.out.println(poppedBlock + " " + maxBlockSize);
    }

    static void dfs(int x, int y, int num) {
        blockCount++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if (grid[nx][ny] == num) {
                grid[nx][ny] = 0;
                dfs(nx, ny, num);
            }
        }
    }
}