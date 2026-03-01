import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            
            if (str.contains("add")) {
                String[] strs = str.split(" ");
                map.put(strs[1], strs[2]);
            } else if (str.contains("remove")) {
                String[] strs = str.split(" ");
                map.remove(strs[1]);
            } else {
                String[] strs = str.split(" ");
                System.out.println(map.getOrDefault(strs[1], "None"));
            }
        }
    }
}