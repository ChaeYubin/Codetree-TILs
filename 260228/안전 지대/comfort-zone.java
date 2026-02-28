import java.util.Scanner;
import java.lang.Math;

public class Main {
    static int n, m;
    static int maxSafeZoneCount = 0;
    static int maxSafeZoneK;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int maxHouseHeight = 0;

        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();

                maxHouseHeight = Math.max(maxHouseHeight, grid[i][j]);
            }        
        }

        // 집의 높이가 K보다 큰 경우를 안전 영역으로 카운팅
        maxSafeZoneK = 1;
        
        for (int k = 1; k < maxHouseHeight; k++) {
            int safeZoneCount = 0;
            int[][] tempGrid = new int[n][m];

            for (int i = 0; i < n; i++) {
                tempGrid[i] = grid[i].clone();  // clone -> 2차원 배열은 얕은 복사가 진행됨
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tempGrid[i][j] > k) {
                        safeZoneCount++;
                        checkSafeZone(tempGrid, i, j, k);
                    }
                }
            }

            if (maxSafeZoneCount < safeZoneCount) {
                maxSafeZoneCount = safeZoneCount;
                maxSafeZoneK = k;
            }
        }

        System.out.print(maxSafeZoneK + " " + maxSafeZoneCount);
    }

    static void checkSafeZone(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            if (grid[nx][ny] > k) {
                grid[nx][ny] = 0;
                checkSafeZone(grid, nx, ny, k);
            }
        }
    }
}