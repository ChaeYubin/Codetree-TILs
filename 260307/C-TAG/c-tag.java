import java.util.Scanner;
import java.util.HashSet;

public class Main {
    static int n, m;
    static int result;
    static int[] arr;
    static String[] groupA, groupB;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        groupA = new String[n];
        groupB = new String[n];
        
        for (int i = 0; i < n; i++) {
            groupA[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            groupB[i] = sc.next();
        }

        result = 0;
        arr = new int[3];

        // 0~(M-1) 중에서 3개 뽑기(조합)
        combination(0, 0);

        System.out.println(result);
    }

    static void combination(int count, int start) {
        if (count == 3) {
            if (canClassify()) {
                result++;
            }

            return;
        }

        for (int i = start; i < m; i++) {
            arr[count] = i;
            combination(count + 1, i + 1);
        }
    }

    static boolean canClassify() {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = "";

            for (int j = 0; j < 3; j++) {
                str += String.valueOf(groupA[i].charAt(arr[j]));
            }

            set.add(str);
        }

        for (int i = 0; i < n; i++) {
            String str = "";

            for (int j = 0; j < 3; j++) {
                str += String.valueOf(groupB[i].charAt(arr[j]));
            }

            if (set.contains(str)) return false;
        }

        return true;
    }
}