import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        // 이동 시에 행과 열이 전부 증가하도록
        int cnt = 0;

        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
                for(int k = i + 1; k < n - 1; k++)
                    for(int l = j + 1; l < m - 1; l++)
                        // 그 중 색깔이 전부 달라지는 경우에만 개수 세기
                        if(grid[0][0] != grid[i][j] && 
                           grid[i][j] != grid[k][l] &&
                           grid[k][l] != grid[n - 1][m - 1])
                            cnt++;
        
        System.out.println(cnt);
    }
}