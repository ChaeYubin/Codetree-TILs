import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            Integer num = sc.nextInt();

            if (!map.containsKey(num)) {
                map.put(num, i + 1);
            }
        }

        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}