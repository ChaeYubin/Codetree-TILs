import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");

            if (command.contains("add")) {
                int k = Integer.valueOf(commands[1]);
                int v = Integer.valueOf(commands[2]);

                map.put(k, v);
            } else if (command.contains("remove")) {
                int k = Integer.valueOf(commands[1]);

                map.remove(k);
            } else if (command.contains("find")) {
                int k = Integer.valueOf(commands[1]);

                if (map.containsKey(k)) {
                    System.out.println(map.get(k));
                } else {
                    System.out.println("None");
                }
            } else {
                if (map.isEmpty()) {
                    System.out.println("None");
                } else {
                    Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
                    
                    while (it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        System.out.print(entry.getValue() + " ");
                    }

                    System.out.println("");
                }
            }
        } 
    }
}