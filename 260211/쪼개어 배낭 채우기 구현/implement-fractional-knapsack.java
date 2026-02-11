import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class Main {
    static class Jewerly implements Comparable<Jewerly> {
        int value;
        int weight;
        double valuePerWeight;

        public Jewerly(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / (double) weight;
        }

        @Override
        public int compareTo(Jewerly o) {
            return Double.compare(o.valuePerWeight, this.valuePerWeight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] valuePerWeight = new double[n];
        ArrayList<Jewerly> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            list.add(new Jewerly(v, w));
        }

        Collections.sort(list);

        double maxValues = 0;

        int index = 0;
        while (m > 0) {
            Jewerly j = list.get(index);

            if (m >= j.weight) {
                maxValues += j.value;
                m -= j.weight;
                index++;
            } else {
                maxValues += j.valuePerWeight * m;
                break;
            }
        }

        System.out.printf("%.3f", maxValues);
    }
}