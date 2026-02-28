import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int happyNumbers = 0;

        // 각 행의 수열 확인
        for (int i = 0; i < n; i++) {
            int count = 1;
            
            if (count >= m) {
                happyNumbers++;
                continue;
            }

            for (int j = 1; j < n; j++) {
                if (grid[j - 1][i] == grid[j][i]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= m) {
                    happyNumbers++;
                    j = n;  
                }
            }
        }
        
        // 각 열의 수열 확인
        for (int i = 0; i < n; i++) {
            int count = 1;

            if (count >= m) {
                happyNumbers++;
                continue;
            }

            for (int j = 1; j < n; j++) {
                if (grid[i][j - 1] == grid[i][j]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= m) {
                    happyNumbers++;
                    j = n;  // j for문 skip
                }
            }
        }

        System.out.println(happyNumbers);
    }
}