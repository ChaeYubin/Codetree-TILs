import java.util.Scanner;

public class Main {
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};  // 북, 동, 남, 서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        String commands = sc.next();

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int x = n / 2;
        int y = n / 2;
        int result = board[x][y];
        int curDir = 0;

        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L':
                    curDir = (curDir + 1) % 4;
                    break;
                case 'R':
                    curDir = (curDir + 4 - 1) % 4; 
                    break;
                case 'F':
                    int nx = x + dir[curDir][0];
                    int ny = y + dir[curDir][1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;

                    result += board[nx][ny];

                    x = nx;
                    y = ny;
                default:
                    break;
            }
        }

        System.out.println(result);
    }
}